package com.karach.arrayproject.model;

import com.karach.arrayproject.exception.ArrayException;
import com.karach.arrayproject.observer.ArrayModelStatisticsObserver;
import com.karach.arrayproject.service.ArrayModelService;
import com.karach.arrayproject.service.impl.ArrayModelServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Warehouse {

  private static final Logger logger = Logger.getLogger(Warehouse.class.getName());
  private static Warehouse instance;
  private final Map<Long, ArrayModelStatistics> observed = new HashMap<>();
  private final List<ArrayModelStatisticsObserver> observers = new ArrayList<>();

  private final ArrayModelStatisticsObserver observer = new ArrayModelStatisticsObserver() {
    @Override
    public void updateStatistics(Long id, ArrayModelStatistics statistics) {
      notifyObservers(id, statistics);
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

    @Override
    public void addObserver(ArrayModelStatisticsObserver observer) {
      observers.add(observer);
    }

    @Override
    public void removeObserver(ArrayModelStatisticsObserver observer) {
      observers.remove(observer);
    }
  };

  private Warehouse() {
  }

  public static Warehouse getInstance() {
    if (instance == null) {
      instance = new Warehouse();
    }
    return instance;
  }

  public void put(Long id, ArrayModelStatistics statistic) {
    observed.put(id, statistic);
    logger.info("Statistics for array with id: " + id + " were changed");
    notifyObservers(id, statistic);
  }

  public void remove(Long id) {
    observed.remove(id);
    logger.info("Array " + id + " was removed from observed");
  }


  private void notifyObservers(Long id, ArrayModelStatistics statistics) {
    for (ArrayModelStatisticsObserver observer : observers) {
      observer.updateStatistics(id, statistics);
    }
  }
}