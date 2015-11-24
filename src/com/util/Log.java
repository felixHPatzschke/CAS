package com.util;

import java.io.IOException;
import java.util.logging.*;

/**
 * Created by Felix Patzschke on 24.11.2015.
 */
public abstract class Log {

    private static FileHandler logFile;
    private static SimpleFormatter formatter;
    private static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static final int STACK_TRACE_INDEX = 2;
    private static boolean dco;

    public static void init(boolean directConsoleOutput, boolean fileOutput) throws IOException {
        dco = directConsoleOutput;
        LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Logger rootLogger = Logger.getLogger("");

        Handler[] handlers = rootLogger.getHandlers();
        if(handlers[0] instanceof ConsoleHandler){
            rootLogger.removeHandler(handlers[0]);
        }
        LOGGER.setLevel(Level.INFO);
        if(fileOutput){
            logFile = new FileHandler("Output.log");
            formatter = new SimpleFormatter();
            logFile.setFormatter(formatter);
            LOGGER.addHandler(logFile);
        }
    }

    public static void setLevel(Level l){
        LOGGER.setLevel(l);
    }

    public static void enableConsoleOutput(boolean b){
        dco = b;
    }

    private static String getCodeLineInfo(){
        String s = "";
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        int c;
        for(c=3; c<ste.length; c++){
            s = (s + "    at " + ste[c].getClassName() + "." + ste[c].getMethodName() + "(" + ste[c].getFileName() + ":" + ste[c].getLineNumber() + ")" + "\n");
        }
        return s;
    }

    public static void log(Level l, String msg){
        msg = (getCodeLineInfo() + msg);
        LOGGER.log(l, msg);
        if(dco){
            if(l.intValue() > Level.INFO.intValue()){
                System.err.println(msg);
            }else{
                System.out.println(msg);
            }
        }
    }

    public static void out(String msg){
        msg = (getCodeLineInfo() + msg);
        LOGGER.info(msg);
        if(dco){
            System.out.println(msg);
        }
    }

    public static void err(String msg){
        msg = (getCodeLineInfo() + msg);
        LOGGER.severe(msg);
        if(dco){
            System.err.println(msg);
        }
    }

}
