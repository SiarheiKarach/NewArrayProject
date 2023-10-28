package com.karach.arrayproject.readfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {
  public static List<String> readLines(String filePath) throws IOException {
    try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
      return stream.collect(Collectors.toList());
    }
  }
}
