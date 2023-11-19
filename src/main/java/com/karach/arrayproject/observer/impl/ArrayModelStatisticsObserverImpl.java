package com.karach.arrayproject.observer.impl;

import com.karach.arrayproject.exception.ArrayException;
import com.karach.arrayproject.model.ArrayModelStatistics;
import com.karach.arrayproject.observer.ArrayModelStatisticsObserver;
import com.karach.arrayproject.service.ArrayModelService;
import com.karach.arrayproject.service.impl.ArrayModelServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ArrayModelStatisticsObserverImpl implements ArrayModelStatisticsObserver  {

  private final List<ArrayModelStatisticsObserver> observers = new ArrayList<>();
  private static final Logger logger = Logger.getLogger(ArrayModelStatisticsObserverImpl.class.getName());
  private final Map<Long, ArrayModelStatistics> observed = new HashMap<>();

  @Override
  public void updateStatistics(Long id, ArrayModelStatistics statistics) {
    notifyObservers(id, statistics);
  }

  @Override
  public void addObserver(ArrayModelStatisticsObserver observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(ArrayModelStatisticsObserver observer) {
    observers.remove(observer);
  }

  private void notifyObservers(Long id, ArrayModelStatistics statistics) {
    for (ArrayModelStatisticsObserver observer : observers) {
      observer.updateStatistics(id, statistics);
    }
  }

  @Override
  public void updateSum(Long id, int[] newArray) throws ArrayException {
    ArrayModelStatistics statistics = observed.get(id);
    if (statistics == null) {
      logger.warning("Array with id: " + id + " is not found");
      return;
    }
    ArrayModelService arrayModelService = new ArrayModelServiceImpl();
    long newSum = arrayModelService.findSum(newArray);
    statistics.setSum(newSum);
    logger.info("Sum fo array with id: " + id + " was actualised");
    notifyObservers(id, statistics);
  }

  public void addObservedArray(Long id, ArrayModelStatistics statistics) {
    observed.put(id, statistics);
  }
}