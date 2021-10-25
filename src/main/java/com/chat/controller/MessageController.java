package com.chat.controller;

import com.chat.models.Message;
import com.chat.service.PusherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MessageController {

    private final PusherService pusherService;

    public MessageController(PusherService pusherService) {
        this.pusherService = pusherService;
    }

    @PostMapping(
            value = "/message",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addMessage(@RequestBody Message message) {
        pusherService.addMessage(message);
        return new ResponseEntity(HttpStatus.OK);
    }
}
