package com.yifan;

import com.yifan.management.WorkerStatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class MasterMain {
    private static final Logger logger = LoggerFactory.getLogger(MasterMain.class);
    public static void main(String[] args) throws IOException, InterruptedException {
        WorkerStatusManager.start();
        JobRunner jobRunner = JobRunner.builder()
                .inputFilePath("D:\\projs\\mapreduce_local\\test_files\\testdata_1.txt")
                .inputSplitNum(3)
                .build();
        jobRunner.run();
        while (true) {
            logger.info("Healthy workers: {}", WorkerStatusManager.getHealthyWorkers());
            sleep(5000);
        }
    }
}