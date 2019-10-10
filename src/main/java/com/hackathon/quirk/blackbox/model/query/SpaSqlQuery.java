package com.hackathon.quirk.blackbox.model.query;

import java.util.ArrayList;

public class SpaSqlQuery {

    public static class Where {

        private String subject = "?subject";

        private String predicate = "?predicate";

        private String object = "?object";

        public Where(String subject, String predicate, String object) {
            this.subject = subject;
            this.predicate = predicate;
            this.object = object;
        }

        @Override
        public String toString() {
            return "Where{" +
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

    private ArrayList<String> selects = new ArrayList<>();

    private ArrayList<Where> wheres = new ArrayList<>();

    private int limit = 25;

    public SpaSqlQuery() {
    }

    public SpaSqlQuery(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "SpaSqlQuery{" +
                "selects=" + selects +
                ", wheres=" + wheres +
                ", limit=" + limit +
                '}';
    }

    public String toQuery() {
        String query = new String();

        query += "PREFIX rdf: <http://schema.org/rdf/> \n" +
                "PREFIX rdfs: <http://schema.org/rdfs/> \n" +
                "PREFIX ne: <http://schema.org/ne/> \n" +
                "SELECT";
        for (String select: this.getSelects()) {
            query += String.format(" %s", select);
        }

        query += "\n";
        query += "WHERE {";

        for (Where where: this.getWheres()) {
            query += String.format(" %s %s %s .\n", where.getSubject(), where.getPredicate(), where.getObject());
        }
        query += "}\n";
        query += String.format(" LIMIT %d", this.limit);
        return query;
    }

    public void addSelect(String item) {
        this.selects.add(item);
    }


    public ArrayList<String> getSelects() {
        return selects;
    }

    public int getLimit() {
        return limit;
    }

    public void setSelects(ArrayList<String> selects) {
        this.selects = selects;
    }


    public void setLimit(int limit) {
        this.limit = limit;
    }

    public ArrayList<Where> getWheres() {
        return wheres;
    }

    public void setWheres(ArrayList<Where> wheres) {
        this.wheres = wheres;
    }
}
