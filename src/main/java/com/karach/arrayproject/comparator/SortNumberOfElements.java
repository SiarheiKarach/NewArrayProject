package com.karach.arrayproject.comparator;

import com.karach.arrayproject.model.RandomArray;
import java.util.Comparator;

public class SortNumberOfElements implements Comparator<RandomArray> {
  @Override
  public int compare(RandomArray o1, RandomArray o2) {
    return Integer.compare(o1.getArray().length, o2.getArray().length);
  }
}
