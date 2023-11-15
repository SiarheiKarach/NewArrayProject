package com.karach.arrayproject.readfile;
import com.karach.arrayproject.exception.ArrayException;
import java.util.List;

public interface ReadFile {


  List<String> readFromFile(String fileName) throws ArrayException;
}