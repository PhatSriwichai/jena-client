package com.hackathon.quirk.blackbox.client;

import com.hackathon.quirk.blackbox.model.jena.JenaFusekiResponse;
import org.json.simple.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name="ontology",
        url="${ontology.endpoint}"
)
public interface OntologyClient {

    @GetMapping(path="/{dataSetName}?query={spaRqlQuery}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JenaFusekiResponse queryKnowledge(
            @PathVariable("dataSetName") String dataSetName,
            @PathVariable("spaRqlQuery") String spaRqlQuery
    );

    @PostMapping(path="/{dataSetName}/update", consumes = "application/sparql-update", headers = {  })
    public JSONObject insertKnowledge(
            @PathVariable("dataSetName") String dataSetName,
            @RequestHeader("Authorization") String accessToken,
            @RequestBody String query
    );
}
