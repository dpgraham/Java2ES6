package com.danielpgraham.parser;

import japa.parser.ast.stmt.BlockStmt;

/**
 * BlockStatementParser
 *
 * Created by danielgraham on 2015-02-28.
 */
public class BlockStatementParser {

    public static ParseOutput parse(Parser parser, BlockStmt blockStmt){
        StringBuilder before = new StringBuilder("{");
        StringBuilder after = new StringBuilder("}");

        return new ParseOutput(before, after, blockStmt.getChildrenNodes(), 0);
    }

}
