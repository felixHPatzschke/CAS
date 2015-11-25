package com.cas;

import com.cas.tree.Term;

/**
 * Created by Felix Patzschke on 25.11.2015.
 */
public class CommandInterface {

    private String input;


    public CommandInterface(){

    }


    public void setInput(String i){
        input = i;
    }

    public void handleInput(){

    }

    public String fetchOutputString(){
        return "";
    }

    public Term fetchOutput(){
        return null;
    }

}
