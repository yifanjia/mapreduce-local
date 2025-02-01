package com.yifan.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class MapperPythonExecutor {
    private static final Logger logger = LoggerFactory.getLogger(MapperPythonExecutor.class);
    private final String inputFilePath;
    private final String pythonScriptPath;
    public MapperPythonExecutor(String inputFilePath, String pythonScriptPath) {
        this.inputFilePath = inputFilePath;
        this.pythonScriptPath = pythonScriptPath;
    }

    public void execute() {
        ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScriptPath);

        Process process = null;
        BufferedReader reader = null;
        try {
            // Redirect input to the Python script
            File inputFile = new File(inputFilePath);
            processBuilder.redirectInput(inputFile);
            // Redirect output and error streams
            processBuilder.redirectErrorStream(true);

            // Start the Python script
            process = processBuilder.start();

            // Read output from the Python script
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Redirect to Java's standard output
            }
        } catch (IOException e) {
            logger.error("Error executing Python script for mapper: ", e);
        } finally {
            // Close the process and the stream reader
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (process != null) {
                process.destroy();
            }
        }
    }

    public static void main(String[] args) {
        String inputFilePath = "D:\\projs\\mapreduce_local\\test_files\\testdata_1.txt";
        String pythonScriptPath = "D:\\projs\\mapreduce_local\\test_scripts\\wordcount_mapper.py";
        MapperPythonExecutor mapperPythonExecutor = new MapperPythonExecutor(inputFilePath, pythonScriptPath);
        mapperPythonExecutor.execute();
    }
}
