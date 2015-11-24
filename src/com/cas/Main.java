package com.cas;

import com.util.Log;

import java.io.IOException;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) {

        try {
            Log.init(true, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.out("Hello, World!", Thread.currentThread().getStackTrace());
        Log.err("Error", Thread.currentThread().getStackTrace());


    }
}
