package com.cas;

import com.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Felix Patzschke on 24.11.2015.
 */
public class Console implements Runnable{

    private BufferedReader bufferedReader;
    private boolean shouldTerminate;

    public Console(){
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        shouldTerminate = false;
    }

    @Override
    public void run() {
        mainLoop();
    }

    private String getInput() throws IOException {
        return bufferedReader.readLine();
    }

    private String getOutput(String input){
        if(input == null){
            shouldTerminate = true;
        }else if(input.startsWith("exit")){
            shouldTerminate = true;
        }
        return "";
    }

    private void mainLoop(){
        while(!shouldTerminate){
            String input;
            try {
                input = getInput();
                String output = getOutput(input);
                System.out.println(output);
            } catch (IOException e) {
                Log.err("IOException while fetching input from console");
                shouldTerminate = true;
            }
        }
    }

}
