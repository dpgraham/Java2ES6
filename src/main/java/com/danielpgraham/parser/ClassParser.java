package com.danielpgraham.parser;

import japa.parser.ast.body.ClassOrInterfaceDeclaration;


/**
 * Created by danielgraham on 2015-02-24.
 */
public class ClassParser {

    public static ParseOutput parse(ClassOrInterfaceDeclaration classObj) throws Exception{
        String className = classObj.getName();

        StringBuilder before = new StringBuilder( String.format("class %s {", className) );
        StringBuilder after = new StringBuilder( String.format("}", className) );

        return new ParseOutput(before, after, classObj.getChildrenNodes());
    }

}
