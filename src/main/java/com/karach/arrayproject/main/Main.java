package com.karach.arrayproject.main;
import com.karach.arrayproject.exception.ArrayModelException;
import com.karach.arrayproject.readfile.ReadFile;
import com.karach.arrayproject.readfile.impl.ReadFileImpl;
import com.karach.arrayproject.service.ArrayModelBubbleSort;
import com.karach.arrayproject.service.ArrayModelService;
import com.karach.arrayproject.parser.NumberParser;
import com.karach.arrayproject.service.impl.ArrayModelServiceImpl;
import com.karach.arrayproject.validation.ArrayValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Logger logger = LogManager.getLogger();
    ReadFile readFile = new ReadFileImpl();
    try {
      InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("myArray.txt");
      List<String> newArrayFromFile = new BufferedReader(new InputStreamReader(inputStream))
              .lines().collect(Collectors.toList());

      int[] newArray = NumberParser.parseStringListToIntArray(newArrayFromFile);
      if (ArrayValidation.isArrayNotEmpty(newArray) && !ArrayValidation.isNegativeNumber(newArray)) {
      ArrayModelService arrayModelService = new ArrayModelServiceImpl();
      ArrayModelBubbleSort arrayModelBubbleSort = new ArrayModelBubbleSort();
      arrayModelBubbleSort.bubbleSort(newArray);

      int min = arrayModelService.findMin(newArray);
      int max = arrayModelService.findMax(newArray);
      int replacedCount = arrayModelService.replaceElementsNumber(newArray, 3, -4);
      double average = arrayModelService.findAverage(newArray);
      int sum = arrayModelService.findSum(newArray);
      int positiveCount = arrayModelService.countPositiveElements(newArray);
      int negativeCount = arrayModelService.countNegativeElements(newArray);

      logger.info("Sorted array: " + Arrays.toString(newArray));
      logger.info("Minimal array value: " + min);
      logger.info("Maximal array value: " + max);
      logger.info("Number of changed elements in array: " + replacedCount);
      logger.info("Average value of array: " + average);
      logger.info("Sum of all elements in array: " + sum);
      logger.info("Sum of positive elements in array: " + positiveCount);
      logger.info("Sum of negative elements in array: " + negativeCount);
      } else {
        logger.error("Array is empty or contains negative numbers.");}
    } catch (ArrayModelException e) {
      logger.error("Error: " + e.getMessage());
    }
  }
}