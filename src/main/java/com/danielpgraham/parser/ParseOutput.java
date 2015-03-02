package com.danielpgraham.parser;

import japa.parser.ast.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * The return object of a 'Parse'.
 */
public class ParseOutput {

    private StringBuilder before;
    private StringBuilder after;
    private List<Node> childNodes;
    private int indents;


    public ParseOutput(StringBuilder before){
        this.before = before;
    }

    public ParseOutput(StringBuilder before, StringBuilder after, List<Node> childNodes, int indents){
        this.before = before == null ? new StringBuilder("") : before;
        this.after = after == null ? new StringBuilder("") : after;
        this.childNodes = childNodes;
        this.indents = indents;
    }

    public ParseOutput(StringBuilder before, StringBuilder after, List<Node> childNodes){
        this.before = before == null ? new StringBuilder("") : before;
        this.after = after == null ? new StringBuilder("") : after;
        this.childNodes = childNodes;
        this.indents = 0;
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

    public int getIndents() {
        return indents;
    }
}
