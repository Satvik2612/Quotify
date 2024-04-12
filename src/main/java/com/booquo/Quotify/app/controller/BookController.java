package com.booquo.Quotify.app.controller;

import com.booquo.Quotify.app.service.BookService;
import com.booquo.Quotify.app.view.BookView;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookView>> getAllBooks() {
        List<BookView> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
