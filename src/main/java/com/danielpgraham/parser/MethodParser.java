package com.danielpgraham.parser;

import japa.parser.ast.Node;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.stmt.BlockStmt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielgraham on 2015-02-24.
 */
public class MethodParser {
    public static ParseOutput parse(MethodDeclaration methodObj) throws Exception{

        // Define the method
        StringBuilder before = new StringBuilder();
        before.append(methodObj.getName() + "(");
        int i = 0;
        for(Parameter parameter : methodObj.getParameters()){
            before.append(parameter.getId());
            if(++i < methodObj.getParameters().size()){
                before.append(", ");
            }
        }
        before.append("){");

        // Close the method
        StringBuilder after = new StringBuilder("}");

        ArrayList<Node> subNodes = new ArrayList<Node>();
        for(Node childNode: methodObj.getChildrenNodes()){
            if(childNode.getClass() == BlockStmt.class){
                subNodes.add(childNode);
            }
        }

        return new ParseOutput(before, after, subNodes);
    }
}
