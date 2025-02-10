package com.kpi.jakartaeecource.utils;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtil {
    public static void logInfo(Class<?> clazz, String message) {
        Logger logger = Logger.getLogger(clazz.getName());
        logger.info(message);
    }

    public static void logWarning(Class<?> clazz, String message) {
        Logger logger = Logger.getLogger(clazz.getName());
        logger.warning(message);
    }

    public static void logError(Class<?> clazz, String message, Exception e) {
        Logger logger = Logger.getLogger(clazz.getName());
        logger.log(Level.SEVERE, message, e);
    }
}
