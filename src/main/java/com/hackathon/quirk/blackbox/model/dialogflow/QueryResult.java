package com.hackathon.quirk.blackbox.model.dialogflow;

import org.json.simple.JSONObject;

public class QueryResult {

    public class Intent {

        private String name;

        private String displayName;

        @Override
        public String toString() {
            return "Intent{" +
                    "name='" + name + '\'' +
                    ", displayName='" + displayName + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }
    }

    private String queryText;

    private JSONObject parameters;

    private Intent intent;

    @Override
    public String toString() {
        return "QueryResult{" +
                "queryText='" + queryText + '\'' +
                ", parameters=" + parameters +
                ", intent=" + intent +
                '}';
    }

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public JSONObject getParameters() {
        return parameters;
    }

    public void setParameters(JSONObject parameters) {
        this.parameters = parameters;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }
}
