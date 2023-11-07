package com.karach.arrayproject.validation;

public class ArrayValidation {

  public static boolean isArrayNotEmpty(int[] array) {
      return (array != null && array.length > 0);
    }

  public static boolean isArrayNotContainsZero(int[] array) {
    for (int num : array) {
      if (num == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPositiveNumber(int num) {
    return num > 0;
  }

  public static boolean isNegativeNumber(int[] array) {
    for (int num : array) {
      if (num < 0) {
        return true;
      }
    }
    return false;
  }

  public static boolean isWithinRange(int num, int min, int max) {
    return num >= min && num <= max;
  }
}
