package com.karach.arrayproject.repository.specification.impl;

import com.karach.arrayproject.exception.ArrayException;
import com.karach.arrayproject.model.ArrayModel;
import com.karach.arrayproject.repository.specification.Specification;
import com.karach.arrayproject.service.ArrayModelService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinArrayValueSpecification implements Specification {
  private int min;
  private ArrayModelService arrayModelService;
  private static final Logger logger = LogManager.getLogger();
  public MinArrayValueSpecification(int min, ArrayModelService arrayModelService) {
    this.min = min;
    this.arrayModelService = arrayModelService;
  }

  @Override
  public boolean specified(ArrayModel arrayModel) throws ArrayException {
    int minArrayValue = arrayModelService.findMin(arrayModel.getArray());
    boolean result = minArrayValue < min;
    logger.info("Checking MinArrayValueSpecification for ArrayModel with ID: {} - Min Array Value: {} - Specified Min: {} - Result: {}",
            arrayModel.getArrayId(), minArrayValue, min, result);
    return result;
  }
}