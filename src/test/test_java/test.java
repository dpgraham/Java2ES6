package com.danielpgraham.test;

import java.io.FileInputStream;
import java.lang.*;

public class MethodChanger {

    /**
     * Main method
     * @param args Array of arguments
     * @throws Exception The exception that is thrown by this method
     */
    public static void main(String[] args) throws Exception {
        // creates an input stream for the file to be parsed
        FileInputStream in = new io.FileInputStream("test.java");
        String testString = "hello world";
        CompilationUnit cu;
        try {
            // parse the file
            cu = JavaParser.parse(in);
        } finally {
            in.close();
        }

        int x = 1 + 1; // Hello world!

        // visit and change the methods names and parameters
        {
            new MethodChangerVisitor().visit(cu, null);
        }

        // prints the changed compilation unit
        System.out.println(cu.toString());
    }

    /**
     * Simple visitor implementation for visiting MethodDeclaration nodes.
     */
    private static class MethodChangerVisitor extends VoidVisitorAdapter {

        @Override
        public void visit(MethodDeclaration n, Object arg) {
            // change the name of the method to upper case
            n.setName(n.getName().toUpperCase());

            // create the new parameter
            Parameter newArg = ASTHelper.createParameter(ASTHelper.INT_TYPE, "value");

            // add the parameter to the method
            ASTHelper.addParameter(n, newArg);
        }
    }
}