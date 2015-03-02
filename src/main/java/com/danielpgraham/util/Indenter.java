package com.danielpgraham.util;

/**
 * Takes a number of indents and returns whitespace matching the indent count
 */
public class Indenter {

    public static String idt(int indents){
        String out = "";
        for(int i=0; i<indents; i++){
            out += "   ";
        }
        return out;
    }

}
