package com.danielpgraham.parser;

import japa.parser.ast.Node;
import japa.parser.ast.stmt.ExpressionStmt;

/**
 * Expression statement parser
 */
public class ExpressionStatementParser {

    public static ParseOutput parse(Parser parser, ExpressionStmt expressionStmt){
        StringBuilder before = new StringBuilder();

        for(Node node : expressionStmt.getChildrenNodes()){
            before.append(parser.parse(node).getBefore());
        }

        return new ParseOutput(before);
    }


}
