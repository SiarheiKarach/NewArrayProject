package com.karach.arrayproject.model;

import com.karach.arrayproject.exception.ArrayException;
import com.karach.arrayproject.observer.RandomArrayStatisticsObserver;
import com.karach.arrayproject.service.ArrayModelService;
import com.karach.arrayproject.service.impl.ArrayModelServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Warehouse {
  private static final Logger logger = LogManager.getLogger();
  private static Warehouse instance;
  private HashMap<Long, RandomArrayStatistics> observed = new HashMap<>();
  private List<RandomArrayStatisticsObserver> observers = new ArrayList<>();

  private Warehouse() {
  }

  public static Warehouse getInstance() {
    if (instance == null) {
      instance = new Warehouse();
    }
    return instance;
  }
  public void addObserver(RandomArrayStatisticsObserver observer) {
    observers.add(observer);
  }

  public void removeObserver(RandomArrayStatisticsObserver observer) {
    observers.remove(observer);
  }

  private void notifyObservers(Long id, RandomArrayStatistics statistics) {
    for (RandomArrayStatisticsObserver observer : observers) {
      observer.updateStatistics(id, statistics);
    }
  }
  public void put(Long id, RandomArrayStatistics statistic) {
    observed.put(id, statistic);
    logger.info("Statistics for array with id: " + id + " were changed");
  }

  public void remove(Long id) {
    observed.remove(id);
    logger.info("Array " + id + " was removed from observed");
  }

  public void updateSum(Long id, int[] newArray) throws ArrayException {
    RandomArrayStatistics statistics = observed.get(id);
    ArrayModelService arrayModelService = new ArrayModelServiceImpl();
    long newSum = arrayModelService.findSum(newArray);
    statistics.setSum(newSum);
    logger.info("Sum for array with id: " + id + " was updated");
    notifyObservers(id, observed.get(id));
  }
}