package com.hackathon.quirk.blackbox.model.dialogflow;

public class OriginalDetectIntentRequest {

    private String source;

    private OriginalDetectIntentRequestPayload payload;

    @Override
    public String toString() {
        return "OriginalDetectIntentRequest{" +
                "source='" + source + '\'' +
                ", payload=" + payload +
                '}';
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public OriginalDetectIntentRequestPayload getPayload() {
        return payload;
    }

    public void setPayload(OriginalDetectIntentRequestPayload payload) {
        this.payload = payload;
    }
}
