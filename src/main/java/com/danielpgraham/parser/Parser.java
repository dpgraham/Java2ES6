package com.danielpgraham.parser;

import com.danielpgraham.util.Indenter;
import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.Node;
import japa.parser.ast.body.*;
import japa.parser.ast.expr.*;
import japa.parser.ast.stmt.*;

import java.io.FileInputStream;

/**
 * General parser that checks the classname of the thing being parsed and parses it.
 */
public class Parser {

    public ParseOutput parse(Node node) {
        Class clazz = node.getClass();
        if(clazz == ClassOrInterfaceDeclaration.class) {
            return ClassParser.parse(this, (ClassOrInterfaceDeclaration) node);
        } else if(clazz == MethodDeclaration.class){
            return MethodParser.parse(this, (MethodDeclaration) node);
        } else if(clazz == BlockStmt.class){
            return BlockStatementParser.parse(this, (BlockStmt) node);
        } else if(clazz == ExpressionStmt.class) {
            return ExpressionStatementParser.parse(this, (ExpressionStmt) node);
        } else if(clazz == ObjectCreationExpr.class) {
            return ObjectCreationExprParser.parse(this, (ObjectCreationExpr) node);
        } else if(clazz == StringLiteralExpr.class) {
            return StringLiteralExprParser.parse(this, (StringLiteralExpr) node);
        } else if(clazz == VariableDeclarationExpr.class) {
            return VariableDeclarationExprParser.parse(this, (VariableDeclarationExpr) node);
        } else {
            return new ParseOutput();
        }
    }

    public static StringBuilder compile(Node node) throws Exception {
        return compile(node, 0);
    }

    public static StringBuilder compile(Node node, int indents) {
        StringBuilder out = new StringBuilder();
        Parser parser = new Parser();
        ParseOutput output;

        output = parser.parse(node);

        out.append(new StringBuilder("\n" + Indenter.idt(indents) + output.getBefore()));
        if(output.getChildNodes() != null) {
            for (Node childNode : output.getChildNodes()) {
                out.append(compile(childNode, indents + output.getIndents()));
            }
        }
        if(output.getAfter() != null)
            out.append(new StringBuilder("\n" + Indenter.idt(indents) + output.getAfter()));

        return out;
    }

    public static String compile(FileInputStream fileInputStream) throws Exception{
        CompilationUnit cu = JavaParser.parse(fileInputStream);
        StringBuilder output = new StringBuilder();
        for(Node childNode : cu.getChildrenNodes()){
            output.append(compile(childNode));
        }

        return output.toString();
    }

}
