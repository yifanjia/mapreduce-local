package com.yifan.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Objects;

@Data
@Builder
public class Worker {
    @NonNull
    private String workerId;
    @NonNull
    private String ip;
    private int port;
    private int mapTaskNum = 0;
    private int reduceTaskNum = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(workerId, worker.workerId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(workerId);
    }
}
