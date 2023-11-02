package com.karach.arrayproject.readfile;
import com.karach.arrayproject.exception.ArrayModelException;
import java.util.List;

public interface ReadFile {
  List<String> readFromFile() throws ArrayModelException;
}