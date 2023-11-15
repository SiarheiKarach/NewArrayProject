package com.karach.arrayproject.model;

public class RandomArray {
  private int arrayId;
  private int[] array;

  public RandomArray(int arrayId, int[] array) {
    this.arrayId = arrayId;
    this.array = array;
  }

  public int getArrayId() {
    return arrayId;
  }

  public void setArrayId(int arrayId) {
    this.arrayId = arrayId;
  }

  public int[] getArray() {
    return array;
  }

  public void setArray(int[] array) {
    this.array = array;
  }

}