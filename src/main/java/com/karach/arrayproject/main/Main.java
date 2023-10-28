package com.karach.arrayproject.main;

import com.karach.arrayproject.exception.ArrayModelException;
import com.karach.arrayproject.logging.Logger;
import com.karach.arrayproject.readfile.ReadFile;
import com.karach.arrayproject.service.ArrayModelBubbleSort;
import com.karach.arrayproject.service.ArrayModelService;
import com.karach.arrayproject.service.impl.ArrayModelServiceImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws IOException {
/*    int[] myArray = new int[10];
    Random random = new Random();
    int i = 0;
    for (int element : myArray) {
      myArray[i] = random.nextInt(-5, 2);
      i++;
    }
    ArrayModelService arrayModelService = new ArrayModelServiceImpl();
    ArrayModelBubbleSort arrayModelBubbleSort = new ArrayModelBubbleSort();
    arrayModelBubbleSort.bubbleSort(myArray);
    //Arrays.sort(myArray);

    try {
      int min = arrayModelService.findMin(myArray);
      int max = arrayModelService.findMax(myArray);
      int replacedCount = arrayModelService.replaceElementsNumber(myArray, 2, 6);
      double average = arrayModelService.findAverage(myArray);
      int sum = arrayModelService.findSum(myArray);
      int positiveCount = arrayModelService.countPositiveElements(myArray);
      int negativeCount = arrayModelService.countNegativeElements(myArray);

      Logger.logInfo("Отсортированный массив: " + Arrays.toString(myArray));
      Logger.logInfo("Минимальное значение массива:" + min);
      Logger.logInfo("Максимальное значение массива:" + max);
      Logger.logInfo("Измененное число элементов массива:" + replacedCount);
      Logger.logInfo("Среднее значение элементов массива: " + average);
      Logger.logInfo("Cумма элементов массива: " + sum);
      Logger.logInfo("Cумма положительных элементов массива: " + positiveCount);
      Logger.logInfo("Cумма отрицательных элементов массива: " + negativeCount);

    } catch (ArrayModelException e) {
      Logger.logError("Ошибка: " + e.getMessage());
    }*/
    String filePath = ".\\src\\main\\resources\\myArray.txt";
    List<String> newArrayFromFile = ReadFile.readLines(filePath);


    int[] newArray = newArrayFromFile.stream()
            .mapToInt(Integer::parseInt)
            .toArray();
    ArrayModelService arrayModelService = new ArrayModelServiceImpl();
    ArrayModelBubbleSort arrayModelBubbleSort = new ArrayModelBubbleSort();
    arrayModelBubbleSort.bubbleSort(newArray);
    try {

      int min = arrayModelService.findMin(newArray);
      int max = arrayModelService.findMax(newArray);
      int replacedCount = arrayModelService.replaceElementsNumber(newArray, 3, -4);
      double average = arrayModelService.findAverage(newArray);
      int sum = arrayModelService.findSum(newArray);
      int positiveCount = arrayModelService.countPositiveElements(newArray);
      int negativeCount = arrayModelService.countNegativeElements(newArray);

      Logger.logInfo("Отсортированный массив: " + Arrays.toString(newArray));
      Logger.logInfo("Минимальное значение массива:" + min);
      Logger.logInfo("Максимальное значение массива:" + max);
      Logger.logInfo("Измененное число элементов массива:" + replacedCount);
      Logger.logInfo("Среднее значение элементов массива: " + average);
      Logger.logInfo("Cумма элементов массива: " + sum);
      Logger.logInfo("Cумма положительных элементов массива: " + positiveCount);
      Logger.logInfo("Cумма отрицательных элементов массива: " + negativeCount);
    } catch (ArrayModelException e) {
      Logger.logError("Ошибка в работе с массивом: " + e.getMessage());
    }
  }
}