package com.karach.arrayproject.parser;
import java.util.List;
import java.util.stream.Collectors;

public class NumberParser {
  public static int[] parseStringListToIntArray(List<String> stringList) {
    return stringList.stream()
            .mapToInt(Integer::parseInt)
            .toArray();
  }
}
