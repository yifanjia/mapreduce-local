package com.yifan;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.WorkerServiceImpl;

import java.io.IOException;

public class WorkerMain {
    private static final Logger logger = LoggerFactory.getLogger(WorkerMain.class);
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length < 1) {
            logger.error("Usage: WorkerMain <port>");
            return;
        }
        int port = Integer.parseInt(args[0]);
        Server server = ServerBuilder
                .forPort(port)
                .addService(new WorkerServiceImpl()).build();
        logger.info("Start worker server at port: {}", port);
        server.start();
        server.awaitTermination();
    }
}