package com.yifan.utils;

import java.io.File;
import java.util.UUID;

public class DirectoryGenerator {

    public static File createWorkerDirectory(int port) {
        String directoryPath = ".\\workers\\worker_" + port;
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs(); // Create the directory if it does not exist
        }
        return directory;
    }
}