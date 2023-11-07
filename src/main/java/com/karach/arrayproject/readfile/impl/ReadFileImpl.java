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

  static Logger logger = LogManager.getLogger();
  static final String fileName = "myArray.txt";

  @Override
  public List<String> readFromFile(String fileName) throws ArrayModelException {

    List<String> lines = new ArrayList<>();
    Scanner scanner = null;
    try {
      File file = new File(fileName);
      scanner = new Scanner(file);

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        lines.add(line);
      }

    } catch (FileNotFoundException e) {
      logger.error("File doesn't exist: " + e.getMessage());
      throw new ArrayModelException("File not found: ", e);

    } finally {
      scanner.close();
    }
    return lines;
  }
}




