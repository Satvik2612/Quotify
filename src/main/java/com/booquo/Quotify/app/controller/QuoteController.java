package com.booquo.Quotify.app.controller;

import com.booquo.Quotify.app.service.QuoteService;
import com.booquo.Quotify.app.view.QuoteView;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class QuoteController {
    private final QuoteService quoteService;

    @GetMapping
    public ResponseEntity<List<QuoteView>> getAllQuotes() {
        List<QuoteView> quotes = quoteService.getAllQuotes();
        return new ResponseEntity<>(quotes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<QuoteView> saveQuote(@RequestBody QuoteView quoteView) {
        QuoteView savedQuote = quoteService.saveQuote(quoteView);
        return new ResponseEntity<>(savedQuote, HttpStatus.CREATED);
    }
}
