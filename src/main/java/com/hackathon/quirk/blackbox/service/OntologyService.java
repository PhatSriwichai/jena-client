package com.hackathon.quirk.blackbox.service;

import com.google.common.base.Strings;
import com.hackathon.quirk.blackbox.client.LineClient;
import com.hackathon.quirk.blackbox.client.OntologyClient;
import com.hackathon.quirk.blackbox.model.DialogFlowWebHook;
import com.hackathon.quirk.blackbox.model.dialogflow.QueryResult;
import com.hackathon.quirk.blackbox.model.jena.FusekiResutBinding;
import com.hackathon.quirk.blackbox.model.jena.JenaFusekiResponse;
import com.hackathon.quirk.blackbox.model.line.Message;
import com.hackathon.quirk.blackbox.model.line.MessageText;
import com.hackathon.quirk.blackbox.model.line.MessageType;
import com.hackathon.quirk.blackbox.model.line.ReplyMessage;
import com.hackathon.quirk.blackbox.model.query.SpaSqlQuery;
import com.hackathon.quirk.blackbox.model.query.SpaSqlUpdate;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OntologyService {

    private String subjectKey = "subject";

    private String verbKey = "verb";

    private String objectKey = "object";

    private String accessToken = "Bearer 354W8HSNRWXwOj8R+5HUvaOguk/eJHJt4OLZu5mOqcytnK86eEKFKh8UA+oOLGra1edotcI+0N6eIVXKBUH+AodZdjz97Vu16vEUsspDjbyKXly+v48W4cb+6UxxeY1FTKkibIiAZCeH/C9Ju+/9LAdB04t89/1O/w1cDnyilFU=";

    @Autowired
    private OntologyClient ontologyClient;

    @Autowired
    private LineClient lineClient;

    public void processOntoLogy(DialogFlowWebHook dialogFlowWebHook) throws Exception {

        QueryResult queryResult = dialogFlowWebHook.getQueryResult();
        JSONObject parameter = queryResult.getParameters();

        String replyToken = dialogFlowWebHook.getOriginalDetectIntentRequest().getPayload().getData().getReplyToken();
        String intentName = dialogFlowWebHook.getQueryResult().getIntent().getDisplayName();

        if (intentName.contains("inquire_")) {
            SpaSqlQuery query = generateQuery(parameter, intentName);
            System.out.println("==> query.toQuery(): "+query.toQuery());
            JenaFusekiResponse jenaFusekiResponse = this.ontologyClient.queryKnowledge("revise1", query.toQuery());

            String text = createTextMessage(jenaFusekiResponse.getResults().getBindings());
            ReplyMessage replyMessage = generateLineResponse(replyToken, text);
            System.out.println("==> replyMessage:" + replyMessage.toString());
            this.lineClient.sendReplyMessage(accessToken, replyMessage);

        } else {
            String text;
            try {
                SpaSqlUpdate query = generateUpdate(parameter, intentName);
                System.out.println("==> query.toQuery(): "+query.toQuery());
                this.ontologyClient.insertKnowledge(
                        "revise1",
                        "Basic YWRtaW46aXN5bHpqa28=",
                        query.toQuery());
                text = "เพิ่มในระบบแล้ว";
            } catch (Exception e) {
                text = "มีบางอย่างที่ไม่รู้จัก";
                System.out.println("==> e: "+e);
            }

            ReplyMessage replyMessage = generateLineResponse(replyToken, text);
            this.lineClient.sendReplyMessage(accessToken, replyMessage);

        }

    }

    public SpaSqlUpdate generateUpdate(JSONObject parameter, String intentName) throws Exception {
        SpaSqlUpdate update = new SpaSqlUpdate();
        ArrayList<SpaSqlUpdate.Insert> inserts = new ArrayList<>();
        switch(intentName) {
            case "add_promotion_card": {
                String promotion = (String) parameter.get("promotion");
                String creditCardName = (String) parameter.get("credit_card");

                System.out.println("==> promotion: "+promotion +", creditCardName: "+creditCardName);
                if (Strings.isNullOrEmpty(promotion) || Strings.isNullOrEmpty(creditCardName)) {
                    throw new Exception("null");
                }

                inserts.add(new SpaSqlUpdate.Insert("ne:"+promotion, "rdf:is_a", "ne:promotion"));
                inserts.add(new SpaSqlUpdate.Insert("ne:"+creditCardName, "rdfs:have", "ne:"+promotion));
                update.setInserts(inserts);
                break;
            }

        }
        return update;
    }

    public SpaSqlQuery generateQuery(JSONObject parameter, String intentName) {

        SpaSqlQuery query = new SpaSqlQuery();
        ArrayList<String> selectes = new ArrayList<>();
        selectes.add("?subject");
        selectes.add("?predicate");
        selectes.add("?object");

        switch(intentName) {
            case "inquire_promotion": {
                String creditCard = (String) parameter.get("credit_card");

                ArrayList<SpaSqlQuery.Where> wheres = new ArrayList<>();
                wheres.add(new SpaSqlQuery.Where("?subject", "rdf:is_a", "ne:promotion"));
                wheres.add(new SpaSqlQuery.Where("?object", "rdf:is_a", "ne:"+creditCard));
                wheres.add(new SpaSqlQuery.Where("?object", "rdfs:have", "?subject"));

                query.setSelects(selectes);
                query.setWheres(wheres);
                break;
            }
            case "inquire_transport": {
                String transport = (String) parameter.get("transport");

                ArrayList<SpaSqlQuery.Where> wheres = new ArrayList<>();
                wheres.add(new SpaSqlQuery.Where("?subject", "rdf:is_a", "ne:promotion"));
                wheres.add(new SpaSqlQuery.Where("?object", "rdf:is_a", "ne:"+transport));
                wheres.add(new SpaSqlQuery.Where("?object", "rdfs:have", "?subject"));

                query.setSelects(selectes);
                query.setWheres(wheres);
                break;
            }
        }
        return query;
    }

    public String createTextMessage(ArrayList<FusekiResutBinding> bindings) {
        String text = "มีดังนี้ครับ\n";

        for (FusekiResutBinding binding: bindings) {
            text += String.format(" - %s ของ %s\n", binding.getSubject().getValue().split("/")[binding.getSubject().getValue().split("/").length-1], binding.getObject().getValue().split("/")[binding.getObject().getValue().split("/").length-1]);
        }

        return text;
    }

    public ReplyMessage generateLineResponse(String replyToken, String text) {
        System.out.println("==> text: "+text);
        MessageText messageText = new MessageText(text);
        ReplyMessage replyMessage = new ReplyMessage();
        replyMessage.setReplyToken(replyToken);

        ArrayList<MessageText> messages = new ArrayList<>();
        messages.add(messageText);
        replyMessage.setMessages(messages);

        return replyMessage;
    }

}
