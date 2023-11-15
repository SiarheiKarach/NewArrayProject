package com.karach.arrayproject.repository.specification;

import com.karach.arrayproject.exception.ArrayException;
import com.karach.arrayproject.model.ArrayModel;
import com.karach.arrayproject.model.RandomArray;

public interface Specification {
  boolean specified (ArrayModel arrayModel) throws ArrayException;
}