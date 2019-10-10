package com.hackathon.quirk.blackbox.controller;

import com.hackathon.quirk.blackbox.model.DialogFlowWebHook;
import com.hackathon.quirk.blackbox.service.OntologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/webhook")
public class WebhookController {

    @Autowired
    private OntologyService ontologyService;

    @GetMapping
    public ResponseEntity verifyWebhook() {
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }

    @PostMapping
    public ResponseEntity receiveWebhook(@RequestBody DialogFlowWebHook body) {
        try {
            System.out.println("body: "+body.toString());
            this.ontologyService.processOntoLogy(body);
        } catch (Exception e) {
            System.out.println(e);
        }

        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }

}
