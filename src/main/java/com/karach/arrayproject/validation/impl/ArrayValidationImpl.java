package com.karach.arrayproject.validation.impl;

import com.karach.arrayproject.validation.ArrayValidation;

public class ArrayValidationImpl implements ArrayValidation {

  @Override
  public boolean isArrayNotEmpty(int[] array) {
    return array != null && array.length > 0;
  }

  @Override
  public boolean isArrayNotContainsZero(int[] array) {
    for (int num : array) {
      if (num == 0) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean isPositiveNumber(int num) {
    return num > 0;
  }

  @Override
  public boolean isNegativeNumber(int[] array) {
    for (int num : array) {
      if (num < 0) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean isWithinRange(int num, int min, int max) {
    return num >= min && num <= max;
  }

  @Override
  public boolean isMinSpecified(int num, int min) {
    return num >= min;
  }

  @Override
  public boolean isMaxSpecified(int num, int max) {
    return num <= max;
  }

  @Override
  public boolean isSumSpecified(int num, int sum) {
    return num == sum;
  }

  @Override
  public boolean isAverageSpecified(double average, double targetAverage) {
    return average == targetAverage;
  }
}