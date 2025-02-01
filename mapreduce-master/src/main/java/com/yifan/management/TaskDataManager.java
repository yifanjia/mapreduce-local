package com.yifan.management;

import com.yifan.model.Task;
import com.yifan.model.TaskReplica;
import com.yifan.model.TaskStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TaskDataManager {
    Map<Task, List<TaskReplica>> taskToReplicasMap = new ConcurrentHashMap<>();
    Map<Task, ReentrantReadWriteLock> taskLockMap = new ConcurrentHashMap<>();
    Map<Task, String> taskResultMap = new ConcurrentHashMap<>();
    public void initTask(Task task) {
        if (!taskLockMap.containsKey(task)) {
            synchronized (this) {
                if (!taskLockMap.containsKey(task)) {
                    taskLockMap.put(task, new ReentrantReadWriteLock());
                    taskToReplicasMap.put(task, new ArrayList<>());
                }
            }
        }
    }

    public void addTaskReplica(Task task, TaskReplica taskReplica) {
        taskLockMap.get(task).writeLock().lock();
        try {
            taskToReplicasMap.get(task).add(taskReplica);
        } finally {
            taskLockMap.get(task).writeLock().unlock();
        }
    }

    public void completeTask(Task task, String filepath) {
        taskLockMap.get(task).writeLock().lock();
        try {
            taskResultMap.put(task, filepath);
        } finally {
            taskLockMap.get(task).writeLock().unlock();
        }
    }

    public TaskStatus getTaskOverallStatus(Task task) {
        taskLockMap.get(task).readLock().lock();
        try {
            if (taskResultMap.containsKey(task)) {
                return TaskStatus.COMPLETED;
            }
            if (taskToReplicasMap.get(task).isEmpty()) {
                return TaskStatus.IDLE;
            }
            for (TaskReplica taskReplica : taskToReplicasMap.get(task)) {
                if (taskReplica.getTaskStatus() == TaskStatus.IN_PROGRESS) {
                    return TaskStatus.IN_PROGRESS;
                }
            }
            return TaskStatus.FAILED;
        } finally {
            taskLockMap.get(task).readLock().unlock();
        }
    }
}
