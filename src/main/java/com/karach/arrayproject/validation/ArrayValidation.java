package com.karach.arrayproject.validation;

public interface ArrayValidation {

  boolean isArrayNotEmpty(int[] array);

  boolean isArrayNotContainsZero(int[] array);

  boolean isPositiveNumber(int num);

  boolean isNegativeNumber(int[] array);

  boolean isWithinRange(int num, int min, int max);

  boolean isMinSpecified(int num, int min);

  boolean isMaxSpecified(int num, int max);

  boolean isSumSpecified(int num, int sum);

  boolean isAverageSpecified(double average, double targetAverage);
}