package com.hackathon.quirk.blackbox.model.line;

import java.util.ArrayList;

public class ReplyMessage {

    private String replyToken;

    private ArrayList<MessageText> messages = new ArrayList<>();

    @Override
    public String toString() {
        return "ReplyMessage{" +
                "replyToken='" + replyToken + '\'' +
                ", messages=" + messages +
                '}';
    }

    public String getReplyToken() {
        return replyToken;
    }

    public void setReplyToken(String replyToken) {
        this.replyToken = replyToken;
    }

    public ArrayList<MessageText> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<MessageText> messages) {
        this.messages = messages;
    }
}
