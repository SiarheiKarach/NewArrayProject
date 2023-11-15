package com.karach.arrayproject.comparator;
import com.karach.arrayproject.model.RandomArray;

import java.util.Comparator;

public class SortFirstElementComparator implements Comparator<RandomArray> {
  @Override
  public int compare(RandomArray o1, RandomArray o2) {
    return Integer.compare(o1.getArray()[0], o2.getArray()[0]);
  }
}
