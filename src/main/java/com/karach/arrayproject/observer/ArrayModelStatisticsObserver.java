package com.karach.arrayproject.observer;

import com.karach.arrayproject.exception.ArrayException;
import com.karach.arrayproject.model.ArrayModelStatistics;

public interface ArrayModelStatisticsObserver {
  void updateStatistics(Long id, ArrayModelStatistics statistics);
  void updateSum(Long id, int[] newArray) throws ArrayException;
  void addObserver(ArrayModelStatisticsObserver observer);
  void removeObserver(ArrayModelStatisticsObserver observer);
}