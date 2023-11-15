package com.karach.arrayproject.repository.specification.impl;

import com.karach.arrayproject.exception.ArrayException;
import com.karach.arrayproject.model.ArrayModel;
import com.karach.arrayproject.repository.specification.Specification;
import com.karach.arrayproject.service.ArrayModelService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AverageArrayValueSpecification implements Specification {
  private double targetAverage;
  private ArrayModelService arrayModelService;
  private static final Logger logger = LogManager.getLogger();

  public AverageArrayValueSpecification(double targetAverage, ArrayModelService arrayModelService) {
    this.targetAverage = targetAverage;
    this.arrayModelService = arrayModelService;
  }

  @Override
  public boolean specified(ArrayModel arrayModel) throws ArrayException {
    double average = arrayModelService.findAverage(arrayModel.getArray());
    boolean result = average == targetAverage;
    logger.info("Checking AverageArrayValueSpecification for ArrayModel with ID: {} - Target Average: {} - Actual Average: {} - Result: {}",
            arrayModel.getArrayId(), targetAverage, average, result);
    return result;
  }
}