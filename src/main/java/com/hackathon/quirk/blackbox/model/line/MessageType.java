package com.hackathon.quirk.blackbox.model.line;

import java.util.Arrays;

public enum MessageType {

    TEXT("text");

    private String value;

    private MessageType(String value) {
        this.value = value;
    }

    public static MessageType fromValue(String value) {
        MessageType[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            MessageType type = var1[var3];
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }

        throw new IllegalArgumentException("Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }

}

