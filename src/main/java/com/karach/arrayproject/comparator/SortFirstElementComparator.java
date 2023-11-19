package com.karach.arrayproject.comparator;
import com.karach.arrayproject.model.ArrayModel;

import java.util.Comparator;

public class SortFirstElementComparator implements Comparator<ArrayModel> {
  @Override
  public int compare(ArrayModel o1, ArrayModel o2) {
    return Integer.compare(o1.getArray()[0], o2.getArray()[0]);
  }
}
