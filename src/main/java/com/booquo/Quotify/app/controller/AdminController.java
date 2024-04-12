package com.booquo.Quotify.app.controller;

import com.booquo.Quotify.app.service.AuthorService;
import com.booquo.Quotify.app.service.BookService;
import com.booquo.Quotify.app.view.AuthorView;
import com.booquo.Quotify.app.view.BookView;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class AdminController {
    private final AuthorService authorService;
    private final BookService bookService;

    @PostMapping("/author")
    public ResponseEntity<AuthorView> saveAuthor(@RequestBody AuthorView authorView) {
        AuthorView savedAuthor = authorService.saveAuthor(authorView);
        return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
    }

    @PostMapping("/book")
    public ResponseEntity<BookView> saveBook(@RequestBody BookView bookView) {
        BookView savedBook = bookService.saveBook(bookView);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }
}
