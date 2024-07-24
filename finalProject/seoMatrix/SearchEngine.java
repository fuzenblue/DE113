import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SearchEngine {
    public static void main(String[] args) {
        List<String> directoryPaths = new ArrayList<>();
        directoryPaths.add("lyrics_data/i_m_yours.txt");
        directoryPaths.add("lyrics_data/just_the_way_you_are.txt");
        directoryPaths.add("lyrics_data/somewhere_over_the_rainbow.txt");
        // Add more directory paths as needed

        List<String> fileContents = readFiles(directoryPaths);
        System.out.println("Files read: " + fileContents.size());
        List<List<String>> tokenizedDocuments = tokenizeDocuments(fileContents);

        List<String> fileNames = getFileNames(directoryPaths);
        Map<String, Map<String, Integer>> wordDocumentMatrix = constructMatrix(fileNames, tokenizedDocuments);

        exportToCSV(wordDocumentMatrix);
    }

    private static List<String> readFiles(List<String> directoryPaths) {
        List<String> fileContents = new ArrayList<>();
        for (String directoryPath : directoryPaths) {
            try {
                Files.walk(Paths.get(directoryPath))
                        .filter(Files::isRegularFile)
                        .filter(path -> path.toString().endsWith(".txt"))
                        .forEach(path -> {
                            try {
                                String content = new String(Files.readAllBytes(path));
                                fileContents.add(content);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileContents;
    }

    private static List<List<String>> tokenizeDocuments(List<String> documents) {
        List<List<String>> tokenizedDocuments = new ArrayList<>();
        for (String document : documents) {
            List<String> tokens = new ArrayList<>();
            String[] words = document.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
            tokens.addAll(Arrays.asList(words));
            tokenizedDocuments.add(tokens);
        }
        return tokenizedDocuments;
    }
    private static Map<String, Map<String, Integer>> constructMatrix(List<String> fileNames, List<List<String>> tokenizedDocuments) {
        Map<String, Map<String, Integer>> wordDocumentMatrix = new HashMap<>();
        for (int i = 0; i < tokenizedDocuments.size(); i++) {
            Map<String, Integer> wordCount = new HashMap<>();
            for (String word : tokenizedDocuments.get(i)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
            String fileNameWithoutExtension = removeFileExtension(fileNames.get(i));
            wordDocumentMatrix.put(fileNameWithoutExtension, wordCount);
        }
        return wordDocumentMatrix;
    }

    private static void exportToCSV(Map<String, Map<String, Integer>> wordDocumentMatrix) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("word_result.csv"))) {
            Set<String> uniqueWords = getUniqueWords(wordDocumentMatrix);
            List<String> sortedUniqueWords = new ArrayList<>(uniqueWords);
            Collections.sort(sortedUniqueWords);

            writer.print("Word,");
            for (String fileName : wordDocumentMatrix.keySet()) {
                writer.print(fileName + ",");
            }
            writer.println();

            for (String word : sortedUniqueWords) {
                writer.print(word + ",");
                for (Map<String, Integer> document : wordDocumentMatrix.values()) {
                    writer.print(document.getOrDefault(word, 0) + ",");
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getFileNames(List<String> directoryPaths) {
        List<String> fileNames = new ArrayList<>();
        for (String directoryPath : directoryPaths) {
            try {
                Files.walk(Paths.get(directoryPath))
                        .filter(Files::isRegularFile)
                        .filter(path -> path.toString().endsWith(".txt"))
                        .forEach(path -> {
                            fileNames.add(path.getFileName().toString());
                        });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileNames;
    }
    private static String removeFileExtension(String fileName) {
        int extensionIndex = fileName.lastIndexOf('.');
        if (extensionIndex != -1) {
            return fileName.substring(0, extensionIndex);
        }
        return fileName;
    }
    private static Set<String> getUniqueWords(Map<String, Map<String, Integer>> wordDocumentMatrix) {
        Set<String> uniqueWords = new HashSet<>();
        for (Map<String, Integer> document : wordDocumentMatrix.values()) {
            uniqueWords.addAll(document.keySet());
        }
        return uniqueWords;
    }
}
