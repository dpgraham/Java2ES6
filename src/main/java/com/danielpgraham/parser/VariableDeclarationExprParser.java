package com.danielpgraham.parser;

import japa.parser.ast.Node;
import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.expr.VariableDeclarationExpr;

/**
 * Variable Declaration parsing
 */
public class VariableDeclarationExprParser {

    public static ParseOutput parse(Parser parser, VariableDeclarationExpr expr){
        ParseOutput parseOutput = new ParseOutput();
        StringBuilder before = new StringBuilder("var ");
        for(Node node : expr.getVars()){
            VariableDeclarator vNode = (VariableDeclarator) node;
            before.append(vNode.getId());
            if(vNode.getInit() != null) {
                before.append(" = ");
                before.append(parser.parse(vNode.getInit()).getBefore());
            }
        }
        before.append(";");
        parseOutput.setBefore(before);
        return parseOutput;
    }

}
