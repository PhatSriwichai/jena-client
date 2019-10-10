package com.hackathon.quirk.blackbox.model;

import com.hackathon.quirk.blackbox.model.dialogflow.AlternativeQueryResult;
import com.hackathon.quirk.blackbox.model.dialogflow.OriginalDetectIntentRequest;
import com.hackathon.quirk.blackbox.model.dialogflow.QueryResult;

import java.util.ArrayList;

public class DialogFlowWebHook {

    private ArrayList<AlternativeQueryResult> alternativeQueryResults;

    private OriginalDetectIntentRequest originalDetectIntentRequest;

    private String session;

    private QueryResult queryResult;

    private String responseId;

    @Override
    public String toString() {
        return "DialogFlowWebHook{" +
                "alternativeQueryResults=" + alternativeQueryResults +
                ", originalDetectIntentRequest=" + originalDetectIntentRequest +
                ", session='" + session + '\'' +
                ", queryResult=" + queryResult +
                ", responseId='" + responseId + '\'' +
                '}';
    }

    public ArrayList<AlternativeQueryResult> getAlternativeQueryResults() {
        return alternativeQueryResults;
    }

    public void setAlternativeQueryResults(ArrayList<AlternativeQueryResult> alternativeQueryResults) {
        this.alternativeQueryResults = alternativeQueryResults;
    }

    public OriginalDetectIntentRequest getOriginalDetectIntentRequest() {
        return originalDetectIntentRequest;
    }

    public void setOriginalDetectIntentRequest(OriginalDetectIntentRequest originalDetectIntentRequest) {
        this.originalDetectIntentRequest = originalDetectIntentRequest;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public QueryResult getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(QueryResult queryResult) {
        this.queryResult = queryResult;
    }

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }
}
