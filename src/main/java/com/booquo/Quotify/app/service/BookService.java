package com.booquo.Quotify.app.service;

import com.booquo.Quotify.app.entity.Book;
import com.booquo.Quotify.app.repo.BookRepo;
import com.booquo.Quotify.app.transformer.BookTransformer;
import com.booquo.Quotify.app.view.BookView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepo bookRepo;
    private final BookTransformer bookTransformer;

    public BookView saveBook(BookView bookView) {
        Book book = bookTransformer.toEntity().apply(bookView);
        Book savedBook = bookRepo.save(book);
        return bookTransformer.toView().apply(savedBook);
    }

    public List<BookView> getAllBooks() {
        List<Book> books = bookRepo.findAll();
        return books.stream().map(bookTransformer.toView()).collect(Collectors.toList());
    }
}
