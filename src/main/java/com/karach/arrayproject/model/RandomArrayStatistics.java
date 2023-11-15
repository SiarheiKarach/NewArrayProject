package com.karach.arrayproject.model;

import com.karach.arrayproject.exception.ArrayException;
import com.karach.arrayproject.service.ArrayModelService;
import com.karach.arrayproject.service.impl.ArrayModelServiceImpl;

public class RandomArrayStatistics {
  private double average;
  private long sum;
  private int max;
  private int min;

  public RandomArrayStatistics(RandomArray randomArray) throws ArrayException {
    ArrayModelService arrayModelService = new ArrayModelServiceImpl();
    this.average = arrayModelService.findAverage(randomArray.getArray());
    this.sum = arrayModelService.findSum(randomArray.getArray());
    this.max = arrayModelService.findMax(randomArray.getArray());
    this.min = arrayModelService.findMin(randomArray.getArray());
  }

  public double getAverage() {
    return average;
  }

  public long getSum() {
    return sum;
  }

  public int getMax() {
    return max;
  }

  public int getMin() {
    return min;
  }

  public void setSum(long sum) {
    this.sum = sum;
  }
}