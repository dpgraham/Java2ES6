public class MethodChanger {

    public static void main(String[] args) throws Exception {
        // creates an input stream for the file to be parsed
        FileInputStream in = new FileInputStream("test.java");

        CompilationUnit cu;
        try {
            // parse the file
            cu = JavaParser.parse(in);
        } finally {
            in.close();
        }

        // visit and change the methods names and parameters
        new MethodChangerVisitor().visit(cu, null);

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