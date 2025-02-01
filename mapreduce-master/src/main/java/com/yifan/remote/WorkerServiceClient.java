package com.yifan.remote;
import com.yifan.api.Worker;
import com.yifan.api.WorkerServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class WorkerServiceClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        WorkerServiceGrpc.WorkerServiceStub stub = WorkerServiceGrpc.newStub(channel);
        StreamObserver<Worker.Empty> requestObserver = stub.heartBeat(new StreamObserver<>() {
            @Override
            public void onNext(Worker.HeartbeatResponse response) {
                // Handle heartbeat response
                System.out.println("Received heartbeat from worker: " + response.getWorkerId());
            }

            @Override
            public void onError(Throwable t) {
                // Handle errors
                System.err.println("Heartbeat stream error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                // Handle stream completion
                System.out.println("Heartbeat stream completed");
            }
        });

        // Send periodic heartbeats
        for (int i = 0; i < 10; i++) {
            Worker.Empty request = Worker.Empty.newBuilder().build();
            requestObserver.onNext(request);
            try {
                Thread.sleep(1000); // Send a heartbeat every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Complete the stream
        requestObserver.onCompleted();
    }
}