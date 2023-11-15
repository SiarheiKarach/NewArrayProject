package com.karach.arrayproject.main;
import com.karach.arrayproject.model.RandomArray;
import com.karach.arrayproject.creator.RandomArrayFactory;
import com.karach.arrayproject.exception.ArrayException;
import com.karach.arrayproject.model.RandomArrayStatistics;
import com.karach.arrayproject.model.ArrayModel;
import com.karach.arrayproject.model.Warehouse;
import com.karach.arrayproject.observer.RandomArrayStatisticsObserver;
import com.karach.arrayproject.readfile.ReadFile;
import com.karach.arrayproject.readfile.impl.ReadFileImpl;
import com.karach.arrayproject.repository.ArrayRepository;
import com.karach.arrayproject.repository.specification.impl.AverageArrayValueSpecification;
import com.karach.arrayproject.repository.specification.impl.MaxArrayValueSpecification;
import com.karach.arrayproject.repository.specification.impl.MinArrayValueSpecification;
import com.karach.arrayproject.repository.specification.impl.SumArrayValueSpecification;
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
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main implements RandomArrayStatisticsObserver {
  private static final Logger logger = LogManager.getLogger();
  public void updateStatistics(Long id, RandomArrayStatistics statistics) {
    logger.info("Received update for array with id: " + id);
    logger.info("Updated Statistics - Sum: " + statistics.getSum());
  }
  public static void main(String[] args) throws ArrayException {
    Logger logger = LogManager.getLogger();
    ReadFile readFile = new ReadFileImpl();
    ArrayRepository arrayRepository = ArrayRepository.getInstance();
    Warehouse warehouse = Warehouse.getInstance();
    warehouse.addObserver(new Main());
    try {
      InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("myArray.txt");
      List<String> newArrayFromFile = new BufferedReader(new InputStreamReader(inputStream))
              .lines().collect(Collectors.toList());

      int[] newArray = NumberParser.parseStringListToIntArray(newArrayFromFile);

      ArrayModel arrayModel = new ArrayModel(1, newArray);
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

        MinArrayValueSpecification minArrayValueSpecification = new MinArrayValueSpecification(-500, arrayModelService);
        boolean isMinSpecified = minArrayValueSpecification.specified(arrayModel);

        MaxArrayValueSpecification maxArrayValueSpecification = new MaxArrayValueSpecification(8, arrayModelService);
        boolean isMaxSpecified = maxArrayValueSpecification.specified(arrayModel);

        SumArrayValueSpecification sumArrayValueSpecification = new SumArrayValueSpecification(165, arrayModelService);
        boolean isSumSpecified = sumArrayValueSpecification.specified(arrayModel);

        AverageArrayValueSpecification averageArrayValueSpecification = new AverageArrayValueSpecification(3, arrayModelService);
        boolean isAverageSpecified = averageArrayValueSpecification.specified(arrayModel);



//      logger.info("Sorted array: " + Arrays.toString(newArray));
//      logger.info("Minimal array value: " + min);
//      logger.info("Maximal array value: " + max);
//      logger.info("Number of changed elements in array: " + replacedCount);
//      logger.info("Average value of array: " + average);
//      logger.info("Sum of all elements in array: " + sum);
//      logger.info("Sum of positive elements in array: " + positiveCount);
//      logger.info("Sum of negative elements in array: " + negativeCount);

        List<int[]> randomArrays = RandomArrayFactory.createRandomArrays(2, 50);
        List<RandomArray> randomArrayObjects = RandomArrayFactory.create(randomArrays);

        for (RandomArray randomArrayObject : randomArrayObjects) {
          long arrayId = randomArrayObject.getArrayId();
          logger.info("Random Array: " + Arrays.toString(randomArrayObject.getArray()));
          RandomArrayStatistics statistics = new RandomArrayStatistics(randomArrayObject);
          warehouse.put(arrayId, statistics);
          logger.info("Statistics - Sum: " + statistics.getSum());
        }
        logger.info("Sorted array: " + Arrays.toString(newArray));
        logger.info("Minimal array value: " + min);
        logger.info("Maximal array value: " + max);
        logger.info("Number of changed elements in array: " + replacedCount);
        logger.info("Average value of array: " + average);
        logger.info("Sum of all elements in array: " + sum);
        logger.info("Sum of positive elements in array: " + positiveCount);
        logger.info("Sum of negative elements in array: " + negativeCount);


      } else {
        logger.error("Array is empty or contains negative numbers.");
      }
    } catch (ArrayException e) {
      logger.error("Error: " + e.getMessage());
    }
  }
}