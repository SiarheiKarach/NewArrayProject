package com.karach.arrayproject.repository.specification.impl;

import com.karach.arrayproject.exception.ArrayException;
import com.karach.arrayproject.model.ArrayModel;
import com.karach.arrayproject.repository.specification.Specification;
import com.karach.arrayproject.service.ArrayModelService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MaxArrayValueSpecification implements Specification {
  private int max;
  private ArrayModelService arrayModelService;
  private static final Logger logger = LogManager.getLogger();
  public MaxArrayValueSpecification(int max, ArrayModelService arrayModelService) {
    this.max = max;
    this.arrayModelService = arrayModelService;
  }

  @Override
  public boolean specified(ArrayModel arrayModel) throws ArrayException {
    int maxArrayValue = arrayModelService.findMax(arrayModel.getArray());
    boolean result = maxArrayValue > max;
    logger.info("Checking MaxArrayValueSpecification for ArrayModel with ID: {} - Max Array Value: {} - Specified Max: {} - Result: {}",
            arrayModel.getArrayId(), maxArrayValue, max, result);
    return result;
  }
}