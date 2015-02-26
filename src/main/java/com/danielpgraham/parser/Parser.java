package com.danielpgraham.parser;

import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.Node;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.MethodDeclaration;

import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Created by danielgraham on 2015-02-24.
 */
public class Parser {

    public static StringBuilder parse(Node node) throws Exception {
        return parse(node, 0);
    }

    /**
     *
     * @param node
     * @param indents
     * @return
     * @throws Exception
     */
    public static StringBuilder parse(Node node, int indents) throws Exception {
        Class clazz = node.getClass();
        StringBuilder out = new StringBuilder();
        ParseOutput output;

        if(clazz == ClassOrInterfaceDeclaration.class) {
            output = ClassParser.parse((ClassOrInterfaceDeclaration) node);
        } else if(clazz == MethodDeclaration.class){
            output = MethodParser.parse((MethodDeclaration) node);
        } else {
            return new StringBuilder("");
        }

        StringBuilder indenter = new StringBuilder();
        for(int i=0; i<indents; i++){
            indenter.append("\t");
        }

        out.append("\n");
        out.append(output.getBefore());
        for(Node childNode : output.getChildNodes()){
            out.append(indenter);
            out.append(parse(childNode, indents + 1));
        }
        out.append(output.getAfter());
        out.append("\n");

        return out;
    }

    public static String parse(FileInputStream fileInputStream) throws Exception{
        CompilationUnit cu = JavaParser.parse(fileInputStream);
        StringBuilder output = new StringBuilder();
        for(Node childNode : cu.getChildrenNodes()){
            output.append(parse(childNode));
        }

        return output.toString();
    }

}
