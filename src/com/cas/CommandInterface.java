package com.cas;

import com.cas.tree.Term;

/**
 * Created by Felix Patzschke on 25.11.2015.
 */
public class CommandInterface {

    private String input,outputString;


    public CommandInterface(){
        input = "";
        outputString = "";
    }


    public void setInput(String i){
        input = i;
    }

    public void handleInput(){
        outputString = input;
    }

    public String fetchOutputString(){
        return outputString;
    }

    public Term fetchOutput(){
        return null;
    }

}
