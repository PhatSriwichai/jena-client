package com.hackathon.quirk.blackbox.model.jena;

import java.util.ArrayList;

public class FusekiResult {

    private ArrayList<FusekiResutBinding> bindings;

    @Override
    public String toString() {
        return "FusekiResult{" +
                "bindings=" + bindings +
                '}';
    }

    public ArrayList<FusekiResutBinding> getBindings() {
        return bindings;
    }

    public void setBindings(ArrayList<FusekiResutBinding> bindings) {
        this.bindings = bindings;
    }
}
