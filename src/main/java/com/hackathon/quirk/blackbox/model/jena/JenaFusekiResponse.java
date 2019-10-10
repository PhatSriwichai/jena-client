package com.hackathon.quirk.blackbox.model.jena;

public class JenaFusekiResponse {

    private FusekiHead head;

    private FusekiResult results;

    @Override
    public String toString() {
        return "JenaFusekiResponse{" +
                "head=" + head +
                ", results=" + results +
                '}';
    }

    public FusekiHead getHead() {
        return head;
    }

    public void setHead(FusekiHead head) {
        this.head = head;
    }

    public FusekiResult getResults() {
        return results;
    }

    public void setResults(FusekiResult results) {
        this.results = results;
    }
}
