package com.alex.watchlist.controller;

import com.alex.watchlist.model.HelloMessage;
import com.alex.watchlist.model.OutputMessage;
import com.alex.watchlist.model.request.MessageRequest;
import com.alex.watchlist.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class GreetingController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(HelloMessage message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }
}
