package com.karach.arrayproject.comparator;

import com.karach.arrayproject.exception.ArrayException;
import com.karach.arrayproject.model.RandomArray;
import com.karach.arrayproject.service.ArrayModelService;
import com.karach.arrayproject.service.impl.ArrayModelServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class SortMinElementComparator implements Comparator<RandomArray> {
  private static final Logger logger = LogManager.getLogger();
  private final ArrayModelService arrayModelService;

  public SortMinElementComparator() {
    this.arrayModelService = new ArrayModelServiceImpl();
  }

  @Override
  public int compare(RandomArray o1, RandomArray o2) {
    try {
      int minElement1 = arrayModelService.findMin(o1.getArray());
      int minElement2 = arrayModelService.findMin(o2.getArray());

      if (minElement1 == minElement2) {
        return 0;
      } else {
        return Integer.compare(minElement1, minElement2);
      }
    } catch (ArrayException e) {
      logger.error("Error while finding min element", e);
      return 0;
    }
  }
}