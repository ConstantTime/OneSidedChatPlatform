package com.chat.controller;

import com.chat.models.Message;
import com.chat.service.PusherService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class MessageController {

    private final PusherService pusherService;

    public MessageController(PusherService pusherService) {
        this.pusherService = pusherService;
    }

    @PostMapping(
            value = "/message/{channelId}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addMessage(@RequestParam String channelId, @RequestBody Message message) {
        log.info("Notification API called {}", message);
        pusherService.addMessage(channelId, message);
        return new ResponseEntity(HttpStatus.OK);
    }
}
