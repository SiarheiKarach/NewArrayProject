package com.karach.arrayproject.readfile.impl;

import com.karach.arrayproject.exception.ArrayModelException;
import com.karach.arrayproject.readfile.ReadFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFileImpl implements ReadFile {

  Logger logger = LogManager.getLogger(ReadFileImpl.class);

  @Override
  public List<String> readFromFile() throws ArrayModelException {
    String fileName = "myArray.txt";
    List<String> lines = new ArrayList<>();
    try {
      File file = new File(fileName);
      Scanner scanner = new Scanner(file);

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        lines.add(line);
        logger.info(line);
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      logger.error("File doesn't exist: " + e.getMessage());
      throw new ArrayModelException("File not found: " + e.getMessage());
    }
    return lines;
  }
}




