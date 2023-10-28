package com.karach.arrayproject.service.impl;

import com.karach.arrayproject.exception.ArrayModelException;
import org.testng.Assert;

public class ArrayModelServiceImplTest {

  @org.testng.annotations.Test
  public void testFindMinPos() throws ArrayModelException {
    ArrayModelServiceImpl arrayModelService = new ArrayModelServiceImpl();
    int[] array = {3, 1, 4, 2, 5};
    int min = arrayModelService.findMin(array);
    Assert.assertEquals(min, 1);
  }

  @org.testng.annotations.Test
  public void testFindMaxNeg() throws ArrayModelException {
    ArrayModelServiceImpl arrayModelService = new ArrayModelServiceImpl();
    int[] array = {3, 1, 4, 2, 5};
    int max = arrayModelService.findMax(array);
    Assert.assertNotEquals(max, 6);
  }

  @org.testng.annotations.Test
  public void testReplaceElementsNumberPos() throws ArrayModelException {
    ArrayModelServiceImpl arrayModelService = new ArrayModelServiceImpl();
    int[] array = {3, 1, 4, 2, 5, 3, 3};
    int replacedCount = arrayModelService.replaceElementsNumber(array, 3, 6);
    Assert.assertEquals(replacedCount, 3);
  }

  @org.testng.annotations.Test
  public void testFindAveragePos() throws ArrayModelException {
    ArrayModelServiceImpl arrayModelService = new ArrayModelServiceImpl();
    int[] array = {3, 1, 4, 2, 5};
    double average = arrayModelService.findAverage(array);
    Assert.assertEquals(average,3);
  }

  @org.testng.annotations.Test
  public void testFindSumPos() throws ArrayModelException {
    ArrayModelServiceImpl arrayModelService = new ArrayModelServiceImpl();
    int[] array = {3, 1, 4, 2, 5};
    double sum = arrayModelService.findSum(array);
    Assert.assertEquals(sum,15);
  }

  @org.testng.annotations.Test
  public void testCountPositiveElementsPos() throws ArrayModelException {
    ArrayModelServiceImpl arrayModelService = new ArrayModelServiceImpl();
    int[] array = {-3, 1, 4, -2, 5, -3, 3};
    int positiveElements = arrayModelService.countPositiveElements(array);
    Assert.assertEquals(positiveElements, 4);
  }

  @org.testng.annotations.Test
  public void testCountNegativeElementsPos() throws ArrayModelException {
    ArrayModelServiceImpl arrayModelService = new ArrayModelServiceImpl();
    int[] array = {-3, 1, 4, -2, 5, -3, 3};
    int negativeElements = arrayModelService.countNegativeElements(array);
    Assert.assertEquals(negativeElements, 3);
  }
}