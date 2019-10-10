package com.hackathon.quirk.blackbox.model.jena;

import java.util.ArrayList;

public class FusekiHead {

    private ArrayList<String> vars;

    @Override
    public String toString() {
        return "FusekiHead{" +
                "vars=" + vars +
                '}';
    }

    public ArrayList<String> getVars() {
        return vars;
    }

    public void setVars(ArrayList<String> vars) {
        this.vars = vars;
    }
}
