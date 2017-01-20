package com.example.support;

import java.util.logging.Logger;

public class LogFactory implements Constants.Defaults {

    private static Logger logger;

    public static Logger getLoggerInstance() {
        if(logger == null) {
            logger = Logger.getLogger(APP_NAME);
        }
        return logger;
    }

}
