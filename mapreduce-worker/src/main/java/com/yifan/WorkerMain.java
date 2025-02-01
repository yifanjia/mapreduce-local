package com.yifan;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.WorkerServiceImpl;

import java.io.IOException;

public class WorkerMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(50051)
                .addService(new WorkerServiceImpl()).build();
        server.start();
        server.awaitTermination();
    }
}