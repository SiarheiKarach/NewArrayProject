package com.karach.arrayproject.repository;

import com.karach.arrayproject.exception.ArrayException;
import com.karach.arrayproject.model.ArrayModel;
import com.karach.arrayproject.repository.specification.Specification;
import com.karach.arrayproject.repository.specification.impl.SumArrayValueSpecification;
import com.karach.arrayproject.service.impl.ArrayModelServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayRepository {
  private static final Logger logger = LogManager.getLogger();
  private static ArrayRepository instance;
  private List<ArrayModel> arrayModels;

  public boolean add(ArrayModel arrayModel) {
    logger.info("Object with id " + arrayModel.getArrayId() + " added to the repository");
    return arrayModels.add(arrayModel);
  }

  public boolean remove(Object o) {
    return arrayModels.remove(o);
  }

  public void sort(Comparator<? super ArrayModel> c) {
    arrayModels.sort(c);
  }

  public ArrayRepository() throws ArrayException {
    this.arrayModels = new ArrayList<>();
    logger.info("ArrayRepository instance created.");
    SumArrayValueSpecification sumArrayValueSpecification = new SumArrayValueSpecification(50, new ArrayModelServiceImpl());
    List<ArrayModel> result = this.query(sumArrayValueSpecification);
  }

  public static ArrayRepository getInstance() throws ArrayException {
    if (instance == null) {
      instance = new ArrayRepository();
    }
    return instance;
  }

  public List<ArrayModel> query(Specification specification) throws ArrayException {
    List<ArrayModel> result = new ArrayList<>();
    for (ArrayModel arrayModel : arrayModels) {
      if (specification.specified(arrayModel)) {
        result.add(arrayModel);
      }
    }
    return result;
  }

}