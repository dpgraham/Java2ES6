package com.danielpgraham.parser;

import japa.parser.ast.expr.StringLiteralExpr;

/**
 * StringLiteral expression parser
 */
public class StringLiteralExprParser {

    public static ParseOutput parse(Parser parser, StringLiteralExpr expr){
        //StringBuilder before
        ParseOutput parseOutput = new ParseOutput();
        String before = String.format("new String('%s')", expr.getValue());
        parseOutput.setBefore(new StringBuilder(before));
        return parseOutput;
    }

}
