package com.alex.watchlist.controller;

import com.alex.watchlist.model.HelloMessage;
import com.alex.watchlist.model.request.MessageRequest;
import com.alex.watchlist.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")

public class ReportController {
    private final ReportRepository reportRepository;
    @GetMapping("/reports")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ResponseEntity<List<HelloMessage>> getAllMessages() {
        List<HelloMessage> reports = reportRepository.findAll();
        return ResponseEntity.ok().body(reports);
    }

    @DeleteMapping("/report/{id}")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    @Transactional
    public ResponseEntity deleteMessage(@PathVariable Long id) {
        reportRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/save/")
    public ResponseEntity createReport(@RequestBody MessageRequest message) {
        reportRepository.save(new HelloMessage(message.getFrom(), message.getText(), message.getTime()));
        return ResponseEntity.ok().build();
    }

}
