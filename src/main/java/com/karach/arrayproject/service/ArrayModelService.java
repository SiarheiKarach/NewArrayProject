package com.karach.arrayproject.service;

import com.karach.arrayproject.exception.ArrayModelException;

public interface ArrayModelService {

  int findMin(int[] arrayModel) throws ArrayModelException;

  int findMax(int[] arrayModel) throws ArrayModelException;

  int replaceElementsNumber(int[] arrayModel, int i, int i1) throws ArrayModelException;

  double findAverage(int[] arrayModel) throws ArrayModelException;

  int findSum(int[] arrayModel) throws ArrayModelException;

  int countPositiveElements(int[] arrayModel) throws ArrayModelException;

  int countNegativeElements(int[] arrayModel) throws ArrayModelException;
}




