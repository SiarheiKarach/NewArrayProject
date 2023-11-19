package com.karach.arrayproject.parser.impl;
import com.karach.arrayproject.parser.NumberParser;

import java.util.List;
public class NumberParserImpl implements NumberParser {
  public int[] parseStringListToIntArray(List<String> stringList) {
    return stringList.stream()
            .mapToInt(Integer::parseInt)
            .toArray();
  }
}
