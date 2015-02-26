package com.danielpgraham.parser;

import japa.parser.ast.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielgraham on 2015-02-24.
 */
public class ParseOutput {

    private StringBuilder before;
    private StringBuilder after;
    private List<Node> childNodes;

    public ParseOutput(StringBuilder before, StringBuilder after, List<Node> childNodes){
        this.before = before;
        this.after = after;
        this.childNodes = childNodes;
    }

    public ParseOutput(){

    }

    public StringBuilder getBefore() {
        return before;
    }

    public void setBefore(StringBuilder before) {
        this.before = before;
    }

    public StringBuilder getAfter() {
        return after;
    }

    public void setAfter(StringBuilder after) {
        this.after = after;
    }

    public List<Node> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(ArrayList<Node> childNodes) {
        this.childNodes = childNodes;
    }
}
