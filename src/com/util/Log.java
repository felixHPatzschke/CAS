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
    private static final int STACK_TRACE_INDEX = 1;
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

    public static void log(Level l, String msg){
        LOGGER.log(l, msg);
        //Add optional console output here
    }

    public static void log(Level l, String msg, StackTraceElement[] ste){
        msg = (ste[1].getFileName() + " in line " + ste[STACK_TRACE_INDEX].getLineNumber() + ":\nClass " + ste[STACK_TRACE_INDEX].getClassName() + "." + ste[STACK_TRACE_INDEX].getMethodName() + ":\n" + msg);
        LOGGER.log(l, msg);
        //Add optional console output here
    }

    public static void out(String msg){
        LOGGER.info(msg);
        if(dco){
            System.out.println(msg);
        }
    }

    public static void out(String msg, StackTraceElement[] ste){
        msg = (ste[1].getFileName() + " in line " + ste[STACK_TRACE_INDEX].getLineNumber() + ":\nClass " + ste[STACK_TRACE_INDEX].getClassName() + "." + ste[STACK_TRACE_INDEX].getMethodName() + "()\n" + msg);
        LOGGER.info(msg);
        if(dco){
            System.out.println(msg);
        }
    }

    public static void err(String msg){
        LOGGER.severe(msg);
        if(dco){
            System.err.println(msg);
        }
    }

    public static void err(String msg, StackTraceElement[] ste){
        msg = (ste[1].getFileName() + " in line " + ste[STACK_TRACE_INDEX].getLineNumber() + ":\nClass " + ste[STACK_TRACE_INDEX].getClassName() + "." + ste[STACK_TRACE_INDEX].getMethodName() + "()\n" + msg);
        LOGGER.severe(msg);
        if(dco){
            System.err.println(msg);
        }
    }

}
