package com.iswfe.games.landlords_fighters.web;

import org.springframework.stereotype.Controller;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/webSocket/build")
@Controller
public class MyWebSocketConfig {

    private static CopyOnWriteArraySet<MyWebSocketConfig> webSocketSet = new CopyOnWriteArraySet<>();

    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        System.out.println("+1.");
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        System.out.println("-1.");
    }

    @OnMessage
    public void onMessage (String message) throws IOException {
        System.out.println("来自客户端的消息:" + message);

        // 消息回发
        sendMessage("服务端已验收! 这是您的消息:"+ message);
    }

    private void sendMessage (String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

}
