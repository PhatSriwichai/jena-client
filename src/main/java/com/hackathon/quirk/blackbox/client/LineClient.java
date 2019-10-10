package com.hackathon.quirk.blackbox.client;

import com.hackathon.quirk.blackbox.model.line.ReplyMessage;
import org.json.simple.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="line", url="${line.endpoint}")
public interface LineClient {

    @PostMapping(path="/bot/message/reply", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JSONObject sendReplyMessage(
            @RequestHeader("Authorization") String accessToken,
            @RequestBody ReplyMessage replyMessage
    );

}
