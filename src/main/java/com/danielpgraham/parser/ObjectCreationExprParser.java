package com.danielpgraham.parser;

import japa.parser.ast.Node;
import japa.parser.ast.expr.ObjectCreationExpr;


/**
 * The parsing of an object creation
 */
public class ObjectCreationExprParser {
    public static ParseOutput parse(Parser parser, ObjectCreationExpr objectCreationExpr) {

        // Define the method
        String args = "(";
        for(Node arg : objectCreationExpr.getArgs()){
            args += parser.parse(arg).getBefore();
        }
        args += ")";

        return new ParseOutput(null, null, null, 1);
    }
}
