package com.yifan.utils;

import java.io.*;
import java.util.*;

public class FileSplitter {
    public static List<String> splitFile(String tempDir, String filePath, int expectedSegmentNum) throws IOException {
        int fileSize = (int) new File(filePath).length();
        int thresholdSize = fileSize / expectedSegmentNum;
        List<String> segmentPaths = new ArrayList<>();
        int currentNumSegments = 0;
        File currentFile = createNewFile(tempDir, ++currentNumSegments, new File(filePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile));

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();

                if (currentNumSegments < expectedSegmentNum && currentFile.length() >= thresholdSize) {
                    // close current file and add new file
                    segmentPaths.add(currentFile.getAbsolutePath());
                    writer.close();
                    currentFile = createNewFile(tempDir, ++currentNumSegments, new File(filePath));
                    writer = new BufferedWriter(new FileWriter(currentFile));
                }
            }
        }
        writer.close();
        return segmentPaths;
    }

    public static File createNewFile(String tempDir, int currentNumSegments, File sourceFile) {
        String newFilePath = String.format("%s\\input_%s_seg%d_%s.txt",
                tempDir, sourceFile.getName(), currentNumSegments, UUIDGenerator.generateUniqueID());
        return new File(newFilePath);
    }
}