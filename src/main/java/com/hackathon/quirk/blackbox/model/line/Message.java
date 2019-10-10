package com.hackathon.quirk.blackbox.model.line;

public class Message {

    private String type;

    public Message() {
    }

    public Message(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Message{" +
                "type=" + type +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
