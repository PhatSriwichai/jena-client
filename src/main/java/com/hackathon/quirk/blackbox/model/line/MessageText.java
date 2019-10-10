package com.hackathon.quirk.blackbox.model.line;

public class MessageText {

    private String type;

    private String text;

    public MessageText(String text) {
        this.type = "text";
        this.text = text;
    }

    @Override
    public String toString() {
        return "MessageText{" +
                "text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
