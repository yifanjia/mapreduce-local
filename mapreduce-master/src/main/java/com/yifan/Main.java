package com.yifan;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JobRunner jobRunner = JobRunner.builder()
                .inputFilePath("D:\\projs\\mapreduce_local\\test_files\\testdata_1.txt")
                .inputSplitNum(3)
                .build();
        jobRunner.run();
    }
}