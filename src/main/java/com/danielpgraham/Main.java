package com.danielpgraham;

import japa.parser.*;
import japa.parser.ast.CompilationUnit;

import java.io.FileInputStream;

public class Main {

    public static void main(String[] args) throws Exception {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        CompilationUnit cu;
        FileInputStream fileInputStream = new FileInputStream(dir + "/src/test/test_java/test.java");
        cu = JavaParser.parse(fileInputStream);
    }
}
