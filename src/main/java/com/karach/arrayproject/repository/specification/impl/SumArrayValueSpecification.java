package com.karach.arrayproject.repository.specification.impl;

import com.karach.arrayproject.exception.ArrayException;
import com.karach.arrayproject.model.ArrayModel;
import com.karach.arrayproject.repository.specification.Specification;
import com.karach.arrayproject.service.ArrayModelService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SumArrayValueSpecification implements Specification {
  private int targetSum;
  private ArrayModelService arrayModelService;
  private static final Logger logger = LogManager.getLogger();

  public SumArrayValueSpecification(int targetSum, ArrayModelService arrayModelService) {
    this.targetSum = targetSum;
    this.arrayModelService = arrayModelService;
  }

  @Override
  public boolean specified(ArrayModel arrayModel) throws ArrayException {
    int sum = arrayModelService.findSum(arrayModel.getArray());
    boolean result = sum == targetSum;
    logger.info("Checking SumArrayValueSpecification for ArrayModel with ID: {} - Target Sum: {} - Actual Sum: {} - Result: {}",
            arrayModel.getArrayId(), targetSum, sum, result);
    return result;
  }
}