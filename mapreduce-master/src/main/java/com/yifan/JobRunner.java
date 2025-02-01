package com.yifan;

import com.yifan.utils.DirectoryGenerator;
import com.yifan.utils.FileSplitter;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Data
@Builder
public class JobRunner {
    private static final Logger logger = LoggerFactory.getLogger(JobRunner.class);
    @NonNull
    private String inputFilePath;
    @NonNull
    private int inputSplitNum;
    public void run() throws IOException {
        File jobDir = DirectoryGenerator.createRandomDirectory();
        logger.info("Start job with inputFile:{}, inputSplitNum:{}, Job directory: {}", inputFilePath, inputSplitNum,
                jobDir.getAbsolutePath());
        List<String> segmentPaths = FileSplitter.splitFile(jobDir.getAbsolutePath(), inputFilePath, inputSplitNum);
        logger.info("Split {} into {} segments at paths: {}", inputFilePath, segmentPaths.size(), segmentPaths);
    }
}
