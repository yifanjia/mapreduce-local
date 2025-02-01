package com.yifan.service;

import com.yifan.api.Worker;
import com.yifan.api.WorkerServiceGrpc;
import io.grpc.stub.StreamObserver;

public class WorkerServiceImpl extends WorkerServiceGrpc.WorkerServiceImplBase {

        @Override
        public void heartBeat(com.yifan.api.Worker.Empty request, StreamObserver<Worker.HeartbeatResponse> responseObserver) {
            Worker.HeartbeatResponse response = Worker.HeartbeatResponse.newBuilder()
                    .setIsAlive(true)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
}
