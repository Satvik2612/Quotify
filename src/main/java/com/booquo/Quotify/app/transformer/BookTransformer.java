package com.booquo.Quotify.app.transformer;

import com.booquo.Quotify.app.entity.Book;
import com.booquo.Quotify.app.exception.AuthorException;
import com.booquo.Quotify.app.repo.AuthorRepo;
import com.booquo.Quotify.app.view.BookView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookTransformer {
    private final AuthorTransformer authorTransformer;

    private final QuoteTransformer quoteTransformer;

    private final AuthorRepo authorRepo;

    public Function<Book, BookView> toView() {
        return book -> {
            BookView bookView = new BookView();
            bookView.setId(book.getId());
            bookView.setTitle(book.getTitle());
            bookView.setAuthors(book.getAuthors().stream().map(authorTransformer.toView()).collect(Collectors.toList()));
            bookView.setQuotes(book.getQuotes().stream().map(quoteTransformer.toView()).collect(Collectors.toList()));
            return bookView;
        };
    }

    public Function<BookView, Book> toEntity() {
        return bookView -> {
            Book book = new Book();
            book.setId(bookView.getId());
            book.setTitle(bookView.getTitle());
            book.setAuthors(bookView.getAuthors().stream()
                    .map(authorDTO -> authorRepo.findById(authorDTO.getId())
                            .orElseThrow(() -> new AuthorException("Author not found with id: " + authorDTO.getId())))
                    .collect(Collectors.toSet()));
            return book;
        };
    }
}
