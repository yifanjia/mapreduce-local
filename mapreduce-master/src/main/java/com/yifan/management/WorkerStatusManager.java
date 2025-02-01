package com.yifan.management;

import com.yifan.model.WorkerMetaData;
import com.yifan.remote.WorkerServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

import static java.lang.Thread.sleep;

public class WorkerStatusManager {
    public static final Integer MAX_NON_ALIVE_RESPONSE_TIMES = 3;
    public static final Integer PING_INTERVAL_SECOND = 5;
    public static final Map<WorkerMetaData, Integer> NON_ALIVE_RESPONSE_TIMES_MAP = new ConcurrentHashMap<>();
    public static final ThreadPoolExecutor HEARTBEAT_EXECUTOR = new ThreadPoolExecutor(4, 8,
            60, java.util.concurrent.TimeUnit.SECONDS,
            new java.util.concurrent.LinkedBlockingQueue<>(512));
    private static final Logger logger = LoggerFactory.getLogger(WorkerStatusManager.class);
    public static void start() {
        WorkerServiceClient workerServiceClient = WorkerServiceClient.getInstance();
        Set<WorkerMetaData> workerMetaDataSet = WorkerMetadataProvider.getWorkerMetaDataSet();
        for (WorkerMetaData workerMetaData : workerMetaDataSet) {
            NON_ALIVE_RESPONSE_TIMES_MAP.put(workerMetaData, 0);
            HEARTBEAT_EXECUTOR.submit(() -> {
                    while (true) {
                        if (!workerServiceClient.ping(workerMetaData)) {
                            NON_ALIVE_RESPONSE_TIMES_MAP.put(workerMetaData, NON_ALIVE_RESPONSE_TIMES_MAP.get(workerMetaData) + 1);
                        } else {
                            NON_ALIVE_RESPONSE_TIMES_MAP.put(workerMetaData, 0);
                        }
                        sleep(PING_INTERVAL_SECOND * 1000);
                    }
                }
            );
        }
    }

    public static Set<WorkerMetaData> getHealthyWorkers() {
        Set<Map.Entry<WorkerMetaData, Integer>> entrySet = NON_ALIVE_RESPONSE_TIMES_MAP.entrySet();
        logger.info("NON_ALIVE_RESPONSE_TIMES_MAP: {}", entrySet);
        return entrySet.stream().filter(entry -> entry.getValue() <= MAX_NON_ALIVE_RESPONSE_TIMES)
                .map(Map.Entry::getKey).collect(java.util.stream.Collectors.toSet());
    }
}
