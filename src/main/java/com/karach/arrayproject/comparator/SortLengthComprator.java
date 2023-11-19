package com.karach.arrayproject.comparator;
import java.util.Comparator;

import com.karach.arrayproject.model.ArrayModel;

public class SortLengthComprator implements Comparator<ArrayModel> {
  @Override
  public int compare(ArrayModel o1, ArrayModel o2) {
    return o1.getArray().length - o2.getArray().length;
  }
}
