package com.hackathon.quirk.blackbox.model.query;

import java.util.ArrayList;

public class SpaSqlUpdate {

    public static class Insert {

        private String subject;

        private String predicate;

        private String object;

        public Insert(String subject, String predicate, String object) {
            this.subject = subject;
            this.predicate = predicate;
            this.object = object;
        }

        @Override
        public String toString() {
            return "Insert{" +
                    "subject='" + subject + '\'' +
                    ", predicate='" + predicate + '\'' +
                    ", object='" + object + '\'' +
                    '}';
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getPredicate() {
            return predicate;
        }

        public void setPredicate(String predicate) {
            this.predicate = predicate;
        }

        public String getObject() {
            return object;
        }

        public void setObject(String object) {
            this.object = object;
        }
    }

    private ArrayList<Insert> inserts = new ArrayList<>();

    @Override
    public String toString() {
        return "SpaSqlUpdate{" +
                "inserts=" + inserts +
                '}';
    }

    public String toQuery() {
        String query = "";
        query += "PREFIX rdf: <http://schema.org/rdf/> \n" +
                "PREFIX rdfs: <http://schema.org/rdfs/> \n" +
                "PREFIX ne: <http://schema.org/ne/> \n";

        query += "INSERT {\n";
        for (Insert insert: this.getInserts()) {
            query += String.format("%s %s %s .\n", insert.getSubject(), insert.getPredicate(), insert.getObject());
        }
        query += "} \nWHERE {}";
        return query;
    }

    public ArrayList<Insert> getInserts() {
        return inserts;
    }

    public void setInserts(ArrayList<Insert> inserts) {
        this.inserts = inserts;
    }
}
