package com.hackathon.quirk.blackbox.model.dialogflow;

public class OriginalDetectIntentRequestPayload {

    public class Data {

        public class Source {
            private String userId;

            private String type;

            @Override
            public String toString() {
                return "Source{" +
                        "userId='" + userId + '\'' +
                        ", type='" + type + '\'' +
                        '}';
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public class Message {

            private String text;

            private String type;

            private String id;

            @Override
            public String toString() {
                return "Message{" +
                        "text='" + text + '\'' +
                        ", type='" + type + '\'' +
                        ", id='" + id + '\'' +
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

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        private String replyToken;

        private long timestamp;

        private Source source;

        private String type;

        private Message message;


        @Override
        public String toString() {
            return "Data{" +
                    "replyToken='" + replyToken + '\'' +
                    ", timestamp=" + timestamp +
                    ", source=" + source +
                    ", type='" + type + '\'' +
                    ", message=" + message +
                    '}';
        }

        public String getReplyToken() {
            return replyToken;
        }

        public void setReplyToken(String replyToken) {
            this.replyToken = replyToken;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public Source getSource() {
            return source;
        }

        public void setSource(Source source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }
    }

    private Data data;

    @Override
    public String toString() {
        return "OriginalDetectIntentRequestPayload{" +
                "data=" + data +
                '}';
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
