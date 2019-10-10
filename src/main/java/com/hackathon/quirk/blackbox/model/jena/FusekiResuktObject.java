package com.hackathon.quirk.blackbox.model.jena;

public class FusekiResuktObject {

    private String type;

    private String value;

    @Override
    public String toString() {
        return "FusekiResuktObject{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
