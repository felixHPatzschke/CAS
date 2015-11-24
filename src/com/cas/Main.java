package com.cas;

import com.util.Log;
import java.io.IOException;
import java.util.logging.Level;
import static com.util.Log.log;

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
