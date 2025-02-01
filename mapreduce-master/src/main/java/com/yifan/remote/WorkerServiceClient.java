package com.yifan.remote;
import com.yifan.api.Worker;
import com.yifan.api.WorkerServiceGrpc;
import com.yifan.model.NetworkAddr;
import com.yifan.model.WorkerMetaData;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class WorkerServiceClient {
    private static final Logger logger = LoggerFactory.getLogger(WorkerServiceClient.class);
    public static final Map<NetworkAddr, StubPairs> STUB_PAIRS_MAP = new ConcurrentHashMap<>();
    public static final Object STUB_PAIRS_MAP_LOCK = new Object();
    public static final int HEART_BEAT_TIMEOUT_SECONDS = 5;
    private static final WorkerServiceClient INSTANCE = new WorkerServiceClient();
    public boolean ping(WorkerMetaData workerMetaData) {
        NetworkAddr networkAddr = workerMetaData.getNetworkAddr();
        initStubPair(networkAddr);
        StubPairs stubPairs = STUB_PAIRS_MAP.get(networkAddr);
        try {
            Worker.Empty request = Worker.Empty.newBuilder().build();
            Worker.HeartbeatResponse response = stubPairs.getBlockingStub()
                    .withDeadlineAfter(HEART_BEAT_TIMEOUT_SECONDS, TimeUnit.SECONDS).heartBeat(request);
            if (response.getIsAlive()) {
                return true;
            }
            logger.info("Worker: {} reported notAlive with response message {}", workerMetaData, response.getMessage());
            return false;
        } catch (Exception e) {
            logger.error("Failed to ping worker: {} with exception", workerMetaData, e);
            return false;
        }
    }

    private void initStubPair(NetworkAddr networkAddr) {
        if (!STUB_PAIRS_MAP.containsKey(networkAddr)) {
            synchronized (STUB_PAIRS_MAP_LOCK) {
                if (!STUB_PAIRS_MAP.containsKey(networkAddr)) { // Double-check locking
                    ManagedChannel channel = ManagedChannelBuilder.forAddress(networkAddr.getHost(), networkAddr.getPort())
                            .usePlaintext()
                            .build();
                    WorkerServiceGrpc.WorkerServiceBlockingStub blockingStub = WorkerServiceGrpc.newBlockingStub(channel);
                    WorkerServiceGrpc.WorkerServiceStub nonBlockingStub = WorkerServiceGrpc.newStub(channel);
                    StubPairs stubPairs = StubPairs.builder()
                            .blockingStub(blockingStub)
                            .nonBlockingStub(nonBlockingStub)
                            .build();
                    STUB_PAIRS_MAP.put(networkAddr, stubPairs);
                }
            }
        }
    }

    private WorkerServiceClient() {}

    public static WorkerServiceClient getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        // Send periodic heartbeats
        WorkerServiceClient workerServiceClient = getInstance();
        WorkerMetaData workerMetaData = WorkerMetaData.builder()
                .workerId("worker-1")
                .networkAddr(NetworkAddr.builder().host("localhost").port(50051).build())
                .build();
        for (int i = 0; i < 10; i++) {
            System.out.println(String.valueOf(i) + workerServiceClient.ping(workerMetaData));
        }
    }
}