package com.karach.arrayproject.model;

import com.karach.arrayproject.exception.ArrayException;
import com.karach.arrayproject.service.ArrayModelService;
import com.karach.arrayproject.service.impl.ArrayModelServiceImpl;

public class ArrayModelStatistics {
  private double average;
  private long sum;
  private int max;
  private int min;

  public ArrayModelStatistics(ArrayModel arrayModel) throws ArrayException {
    ArrayModelService arrayModelService = new ArrayModelServiceImpl();
    this.average = arrayModelService.findAverage(arrayModel.getArray());
    this.sum = arrayModelService.findSum(arrayModel.getArray());
    this.max = arrayModelService.findMax(arrayModel.getArray());
    this.min = arrayModelService.findMin(arrayModel.getArray());
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