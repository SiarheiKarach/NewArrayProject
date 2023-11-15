package com.karach.arrayproject.creator;

import com.karach.arrayproject.exception.ArrayException;
import com.karach.arrayproject.model.RandomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomArrayFactory {

  private static final Logger logger = LogManager.getLogger();

  public static RandomArray create(int arrayId, int[] array) throws ArrayException {
    RandomArray randomArray = new RandomArray(arrayId, array);
    logger.info("Created RandomArray with ID {}: {}", arrayId, Arrays.toString(array));
    return randomArray;
  }

  public static List<RandomArray> create(List<int[]> listOfArrays) throws ArrayException {
    if (listOfArrays == null) {
      throw new ArrayException("List of arrays is null");
    }
    List<RandomArray> result = new ArrayList<>();
    for (int i = 0; i < listOfArrays.size(); i++) {
      result.add(create(i + 1, listOfArrays.get(i)));
    }
    return result;
  }

  public static List<int[]> createRandomArrays(int count, int length) throws ArrayException {
    if (count <= 0 || length <= 0) {
      throw new ArrayException("Count and length should be greater than 0");
    }

    List<int[]> result = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      int[] randomArray = generateRandomArray(length);
      result.add(randomArray);
    }

    return result;
  }

  private static int[] generateRandomArray(int length) {
    Random random = new Random();
    int[] randomArray = new int[length];
    for (int i = 0; i < length; i++) {
      randomArray[i] = random.nextInt();
    }
    return randomArray;
  }
}