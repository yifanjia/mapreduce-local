package com.yifan.utils;

import java.io.File;
import java.util.UUID;

public class DirectoryGenerator {

    public static File createRandomDirectory() {
        String directoryPath = ".\\splitInputFiles\\" + UUID.randomUUID();
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs(); // Create the directory if it does not exist
        }
        return directory;
    }
}