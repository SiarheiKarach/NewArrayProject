package com.karach.arrayproject.service.impl;

import com.karach.arrayproject.exception.ArrayException;
import com.karach.arrayproject.service.ArrayModelService;

public class ArrayModelServiceImpl implements ArrayModelService {

  @Override
  public int findMin(int[] arrayModel) throws ArrayException {
    if (arrayModel == null || arrayModel.length == 0) {
      throw new ArrayException("Array is empty or null");
    }

    int min = arrayModel[0];
    for (int i = 1; i < arrayModel.length; i++) {
      if (arrayModel[i] < min) {
        min = arrayModel[i];
      }
    }
    return min;
  }

  @Override
  public int findMax(int[] arrayModel) throws ArrayException {
    if (arrayModel == null || arrayModel.length == 0) {
      throw new ArrayException("Array is empty or null");
    }

    int max = arrayModel[0];
    for (int i = 1; i < arrayModel.length; i++) {
      if (arrayModel[i] > max) {
        max = arrayModel[i];
      }
    }
    return max;
  }

  @Override
  public int replaceElementsNumber(int[] arrayModel, int oldValue, int newValue) throws ArrayException {
    if (arrayModel == null || arrayModel.length == 0) {
      throw new ArrayException("Array is empty or null");
    }
    int count = 0;
    for (int i = 0; i < arrayModel.length; i++) {
      if (arrayModel[i] == oldValue) {
        arrayModel[i] = newValue;
        count++;
      }
    }
    return count;
  }

  @Override
  public double findAverage(int[] arrayModel) throws ArrayException {
    if (arrayModel == null || arrayModel.length == 0) {
      throw new ArrayException("Array is empty or null");
    }
    int sum = 0;
    for (int value : arrayModel) {
      sum += value;
    }
    double average = (double) sum / arrayModel.length;
    return average;
  }

  @Override
  public int findSum(int[] arrayModel) throws ArrayException {
    if (arrayModel == null || arrayModel.length == 0) {
      throw new ArrayException("Array is empty or null");
    }
    int sum = 0;
    for (int value : arrayModel) {
      sum += value;
    }
    return sum;
  }

  @Override
  public int countPositiveElements(int[] arrayModel) throws ArrayException {
    if (arrayModel == null || arrayModel.length == 0) {
      throw new ArrayException("Array is empty or null");
    }
    int count = 0;
    for (int value : arrayModel) {
      if (value > 0) {
        count++;
      }
    }
    return count;
  }

  @Override
  public int countNegativeElements(int[] arrayModel) throws ArrayException {
    if (arrayModel == null || arrayModel.length == 0) {
      throw new ArrayException("Array is empty or null");
    }
    int count = 0;
    for (int value : arrayModel) {
      if (value < 0) {
        count++;
      }
    }
    return count;
  }
}
