package com.sjh.peanutfriends_0324.controller;

import com.sjh.peanutfriends_0324.dto.ChattingDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChattingController {
    @MessageMapping("/receive")
    @SendTo("/send")
    public ChattingDto ChattingHandler(ChattingDto chattingDto) {
        String userName = chattingDto.getUserName();
        String content = chattingDto.getContent();

        ChattingDto result = new ChattingDto(userName, content);
        return result;
    }
}
