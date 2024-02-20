package org.example.socket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;

@ServerEndpoint("/websocket")
public class WebSocketHandler {
    private Map<String, MessageHandler> protocolHandlers;

    public WebSocketHandler() {
        protocolHandlers = new HashMap<>();
        // 增加通信方法
        protocolHandlers.put("protocol1", new Protocol1Handler());
        protocolHandlers.put("protocol2", new Protocol2Handler());
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("WebSocket connection opened. Session ID: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Received message from client: " + message);

        // 解析消息，获取协议类型
        String protocol = parseProtocol(message);

        // 根据协议类型获取相应的处理器，并进行处理
        MessageHandler handler = protocolHandlers.get(protocol);
        if (handler != null) {
            handler.handleMessage(message, session);
        } else {
            handleUnknownProtocol(message, session);
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("WebSocket connection closed. Session ID: " + session.getId() + ", Close Reason: " + closeReason.getReasonPhrase());
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("WebSocket error occurred. Session ID: " + session.getId() + ", Error: " + error.getMessage());
    }

    private String parseProtocol(String message) {
        // 解析消息中的协议类型，并返回
        // 可以根据消息的格式或约定来进行解析，这里仅作示例
        return "protocol1";
    }

    private void handleUnknownProtocol(String message, Session session) {
        // 处理未知协议的逻辑
        System.out.println("Unknown protocol message received: " + message);
    }

    // 定义通用的消息处理接口
    private interface MessageHandler {
        void handleMessage(String message, Session session);
    }

    // 协议1的处理器
    private class Protocol1Handler implements MessageHandler {
        @Override
        public void handleMessage(String message, Session session) {
            // 处理协议1的逻辑
            System.out.println("Handling protocol 1 message: " + message);
        }
    }

    // 协议2的处理器
    private class Protocol2Handler implements MessageHandler {
        @Override
        public void handleMessage(String message, Session session) {
            // 处理协议2的逻辑
            System.out.println("Handling protocol 2 message: " + message);
        }
    }
}
