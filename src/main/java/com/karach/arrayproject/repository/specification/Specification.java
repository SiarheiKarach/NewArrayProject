package com.karach.arrayproject.repository.specification;

import com.karach.arrayproject.exception.ArrayException;
import com.karach.arrayproject.model.ArrayModel;

public interface Specification {
  boolean specified (ArrayModel arrayModel) throws ArrayException;
}