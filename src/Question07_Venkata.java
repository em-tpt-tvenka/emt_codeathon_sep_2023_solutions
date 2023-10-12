package src;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// Interface for file filtering
interface FileFilter {
    boolean accept(File file);
}

public class Question07_Venkata {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a valid Windows directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory Not Found on the Filesystem");
            return;
        }

        Map<String, List<String>> fileMap = new TreeMap<>();
        // Implement a file filter for .txt and .exe files
        FileFilter txtAndExeFileFilter = file -> file.isFile() && (file.getName().endsWith(".txt") || file.getName().endsWith(".exe"));

        collectFiles(directory, fileMap, txtAndExeFileFilter);

        for (Map.Entry<String, List<String>> entry : fileMap.entrySet()) {
            System.out.println("Directory: " + entry.getKey());
            System.out.println("Files: "+entry.getKey()+":  " + entry.getValue());
        }
    }

    private static void collectFiles(File directory, Map<String, List<String>> fileMap, FileFilter fileFilter) {
        File[] files = directory.listFiles();
        if (files != null) {
            List<String> filteredFiles = new ArrayList<>();
            for (File file : files) {
                if (fileFilter.accept(file)) {
                    filteredFiles.add(file.getName());
                }
            }
            if (!filteredFiles.isEmpty()) {
                fileMap.put(directory.getAbsolutePath(), filteredFiles);
            }

            for (File subDirectory : files) {
                if (subDirectory.isDirectory()) {
                    collectFiles(subDirectory, fileMap, fileFilter);
                }
            }
        }
    }
}
