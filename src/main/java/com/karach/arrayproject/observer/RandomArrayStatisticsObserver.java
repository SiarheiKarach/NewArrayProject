package com.karach.arrayproject.observer;

import com.karach.arrayproject.model.RandomArrayStatistics;

public interface RandomArrayStatisticsObserver {
  void updateStatistics(Long id, RandomArrayStatistics statistics);
}
