package io.uetunited.oneheed.service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacebookMessageSubscriber implements MessageListener {

    public static List<String> messageList = new ArrayList<String>();

    @Override
    public void onMessage(Message message, byte[] bytes) {
        messageList.add(message.toString());
        System.out.println("Message received: " + new String(message.getBody()));
    }
}
