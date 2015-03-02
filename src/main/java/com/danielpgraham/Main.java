package com.danielpgraham;

import com.danielpgraham.parser.Parser;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        FileInputStream fileInputStream = new FileInputStream(dir + "/src/test/test_java/test.java");
        String output = Parser.compile(fileInputStream);

        PrintWriter bufferedWriter = new PrintWriter(new FileWriter("test.js"));
        bufferedWriter.write(output);
        bufferedWriter.close();
    }
}
