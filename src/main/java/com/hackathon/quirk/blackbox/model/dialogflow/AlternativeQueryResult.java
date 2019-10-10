package com.hackathon.quirk.blackbox.model.dialogflow;

public class AlternativeQueryResult {

    private String queryText;

    private String languageCode;

    @Override
    public String toString() {
        return "AlternativeQueryResult{" +
                "queryText='" + queryText + '\'' +
                ", languageCode='" + languageCode + '\'' +
                '}';
    }

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }
}
