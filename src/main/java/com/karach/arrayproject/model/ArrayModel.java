package com.karach.arrayproject.model;

public class ArrayModel {
  private int arrayId;
  private static int[] array;

  public ArrayModel(int arrayId, int[] array) {
    this.arrayId = arrayId;
    this.array = array;
  }

  public int getArrayId() {
    return arrayId;
  }

  public void setArrayId(int arrayId) {
    this.arrayId = arrayId;
  }

  public static int[] getArray() {
    return array;
  }

  public void setArray(int[] array) {
    this.array = array;
  }

}
