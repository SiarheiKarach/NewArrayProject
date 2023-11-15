package com.karach.arrayproject.repository.specification.impl;

import com.karach.arrayproject.model.ArrayModel;
import com.karach.arrayproject.repository.specification.Specification;

public class ArrayIdSpecification implements Specification {
  private final int arrayId;

  public ArrayIdSpecification(int arrayId) {
    this.arrayId = arrayId;
  }

  @Override
  public boolean specified(ArrayModel arrayModel) {
    return arrayModel.getArrayId() == arrayId;
  }
}