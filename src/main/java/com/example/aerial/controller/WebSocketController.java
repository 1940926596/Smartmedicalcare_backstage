package com.example.aerial.controller;


import com.example.aerial.pojo.SocketMsg;
import com.example.aerial.utils.chat.WebSocket;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/websocket")
public class WebSocketController {
    @Autowired
    private WebSocket webSocket;

    @PostMapping(value = "/sendMsg", produces = "application/json;charset=utf-8")
    public String sendMsg(@RequestBody SocketMsg socketMsg) {
//        System.out.println(socketMsg);
        boolean send = webSocket.sendOneMessage(socketMsg.getSend_id(),socketMsg.getReceiver_id(), socketMsg.getContent());
        if (send) {
            return "发送成功";
        } else {
            return "发送失败";
        }
    }

    @GetMapping(value = "/getAllSockets", produces = "application/json;charset=utf-8")
    public String sendMsg() throws JsonProcessingException {
//        return webSocket.getSessionInfo();
        return "hello";
    }

}

