package com.karach.arrayproject.comparator;
import java.util.Comparator;
import com.karach.arrayproject.model.RandomArray;

public class SortLengthComprator implements Comparator<RandomArray> {
  @Override
  public int compare(RandomArray o1, RandomArray o2) {
    return o1.getArray().length - o2.getArray().length;
  }
}
