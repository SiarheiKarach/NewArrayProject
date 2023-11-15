package com.karach.arrayproject.service;

import com.karach.arrayproject.exception.ArrayException;

public interface ArrayModelService {

  int findMin(int[] arrayModel) throws ArrayException;

  int findMax(int[] arrayModel) throws ArrayException;

  int replaceElementsNumber(int[] arrayModel, int i, int i1) throws ArrayException;

  double findAverage(int[] arrayModel) throws ArrayException;

  int findSum(int[] arrayModel) throws ArrayException;

  int countPositiveElements(int[] arrayModel) throws ArrayException;

  int countNegativeElements(int[] arrayModel) throws ArrayException;
}




