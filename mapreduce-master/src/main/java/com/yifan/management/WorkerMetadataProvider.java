package com.yifan.management;

import com.yifan.model.NetworkAddr;
import com.yifan.model.WorkerMetaData;

import java.util.HashSet;
import java.util.Set;

public class WorkerMetadataProvider {
    public static final Set<WorkerMetaData> WORKER_META_DATA_SET = new HashSet<>();
    static {
        WORKER_META_DATA_SET.add(WorkerMetaData.builder().workerId("w1").networkAddr(NetworkAddr.builder().host("localhost").port(50551).build()).build());
        WORKER_META_DATA_SET.add(WorkerMetaData.builder().workerId("w2").networkAddr(NetworkAddr.builder().host("localhost").port(50552).build()).build());
        WORKER_META_DATA_SET.add(WorkerMetaData.builder().workerId("w3").networkAddr(NetworkAddr.builder().host("localhost").port(50553).build()).build());
    }
    public static Set<WorkerMetaData> getWorkerMetaDataSet() {
        return WORKER_META_DATA_SET;
    }
}
