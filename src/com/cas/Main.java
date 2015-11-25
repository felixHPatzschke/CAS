package com.cas;

import com.util.Log;
import com.util.ui.Console;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            Log.init(true, true);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        new Console().run();

    }

}
