package com.danielpgraham.parser;

import japa.parser.ast.body.ClassOrInterfaceDeclaration;


/**
 * ClassParser
 *
 * Created by danielgraham on 2015-02-24.
 */
public class ClassParser {

    public static ParseOutput parse(Parser parser, ClassOrInterfaceDeclaration classObj) {
        String className = classObj.getName();
        String ext = classObj.getExtends() != null ? classObj.getExtends().get(0).getName() : "Object";

        // Define the class and add the extends (must extend Object at minimum)
        StringBuilder before = new StringBuilder( String.format("class %s ", className) );
        before.append( new StringBuilder( String.format("extends %s ", ext) ) );
        before.append(new StringBuilder("{"));
        StringBuilder after = new StringBuilder( "}");

        return new ParseOutput(before, after, classObj.getChildrenNodes(), 1);
    }

}
