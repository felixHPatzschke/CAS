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
    private CommandInterface commandInterface;
    private boolean shouldTerminate;

    public Console(){
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        shouldTerminate = false;
        commandInterface = new CommandInterface();
    }

    @Override
    public void run() {
        mainLoop();
    }

    private void mainLoop(){
        String input, output;
        while(!shouldTerminate){
            try {
                input = bufferedReader.readLine();
                if(input == null || input.startsWith("exit")){
                    shouldTerminate = true;
                    output = "";
                }else{
                    commandInterface.setInput(input);
                    commandInterface.handleInput();
                    output = commandInterface.fetchOutputString();
                }
                System.out.println(output);
            } catch (IOException e) {
                Log.err("IOException while fetching input from console");
                shouldTerminate = true;
            }
        }
    }

}
