package com.chat.service;

import com.chat.models.Message;
import com.pusher.rest.Pusher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class PusherService {
    @Value("${pusher.app_id}")
    private String appId;

    @Value("${pusher.key}")
    private String key;

    @Value("${pusher.secret-key}")
    private String secretKey;

    @Value("${pusher.cluster}")
    private String cluster;

    public void addMessage(Message message) {
        Pusher pusher = new Pusher(appId, key, secretKey);
        pusher.setCluster(cluster);
        pusher.setEncrypted(true);

        pusher.trigger("my-channel", "my-event",
                Collections.singletonMap("message", message.getText()));
    }
}
