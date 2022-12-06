import dto.*;
import models.*;
import parsers.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException {

        String url = "https://skillbox-java.github.io/";

        HtmlParser htmlParser = new HtmlParser();
        htmlParser.setUrl(url);
        Metro metro = new Metro();
        metro.setLines(htmlParser.getLines());
        metro.setStations(htmlParser.getStations(metro.getLines()));

        String projectPath = System.getProperty("user.dir");

        File file = new File(projectPath + "\\data");
        List<File> files = new ArrayList<>();
        Files.walkFileTree(file.toPath(), new SimpleFileVisitor<>() {
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                if (path.toFile().isFile()) {
                    files.add(path.toFile());
                }
                return FileVisitResult.CONTINUE;
            }
        });

        files.forEach(f -> {
            if (fileNameContains(f, ".json")) {
                try {
                    if (fileNameContains(f, "date")) {
                        JsonParser.getStationsFromFile(f).forEach(s -> setStationDate(metro, s));
                    }
                    if (fileNameContains(f, "depth")) {
                        JsonParser.getStationsFromFile(f).forEach(s -> setStationDepth(metro, s));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (fileNameContains(f, ".csv")) {
                try {
                    if (fileNameContains(f, "date")) {
                        CsvParser.getStationsFromFile(f).forEach(s -> setStationDate(metro, s));
                    }
                    if (fileNameContains(f, "depth")) {
                        CsvParser.getStationsFromFile(f).forEach(s -> setStationDepth(metro, s));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        File jsonFile = new File(projectPath + "\\stations.json");
        JsonParser.saveStationsToJsonFile(jsonFile, metro);
    }

    private static boolean fileNameContains(File file, String txt) {
        return file.getName().contains(txt);
    }

    private static void setStationDate(Metro metro, StationDto s) {
        metro.getStations().forEach(m -> {
            if (s.getKey().replace("ё", "е").equalsIgnoreCase(m.getName()) && m.getDate() == null) {
                m.setDate(s.getValue());
            }
        });
    }

    private static void setStationDepth(Metro metro, StationDto s) {
        metro.getStations().forEach(m -> {
            if (s.getKey().replace("ё", "е").equalsIgnoreCase(m.getName()) && m.getDepth() == null) {
                m.setDepth(s.getValue());
            }
        });
    }
}
