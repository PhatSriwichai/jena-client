package com.hackathon.quirk.blackbox.model.jena;

public class FusekiResutBinding {

    private FusekiResuktObject subject;

    private FusekiResuktObject predicate;

    private FusekiResuktObject object;

    @Override
    public String toString() {
        return "FusekiResutBinding{" +
                "subject=" + subject +
                ", predicate=" + predicate +
                ", object=" + object +
                '}';
    }

    public FusekiResuktObject getSubject() {
        return subject;
    }

    public void setSubject(FusekiResuktObject subject) {
        this.subject = subject;
    }

    public FusekiResuktObject getPredicate() {
        return predicate;
    }

    public void setPredicate(FusekiResuktObject predicate) {
        this.predicate = predicate;
    }

    public FusekiResuktObject getObject() {
        return object;
    }

    public void setObject(FusekiResuktObject object) {
        this.object = object;
    }
}
