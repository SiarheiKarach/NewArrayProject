package com.karach.arrayproject.logging;

import org.apache.logging.log4j.LogManager;

public class Logger {
  static org.apache.logging.log4j.Logger logger = LogManager.getLogger();

  public static void logInfo(String message) {
    logger.info(message);
  }

  public static void logError(String message) {
    logger.error(message);
  }
}
