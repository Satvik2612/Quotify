package com.booquo.Quotify.app.transformer;

import com.booquo.Quotify.app.entity.Book;
import com.booquo.Quotify.app.entity.Quote;
import com.booquo.Quotify.app.exception.BookException;
import com.booquo.Quotify.app.repo.BookRepo;
import com.booquo.Quotify.app.view.QuoteView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class QuoteTransformer {
    private final BookRepo bookRepo;

    public Function<Quote, QuoteView> toView() {
        return quote -> {
            QuoteView quoteView = new QuoteView();
            quoteView.setId(quote.getId());
            quoteView.setContent(quote.getContent());
            quoteView.setBookId(quote.getBook().getId());
            return quoteView;
        };
    }

    public Function<QuoteView, Quote> toEntity() {
        return quoteView -> {
            Quote quote = new Quote();
            quote.setId(quoteView.getId());
            quote.setContent(quoteView.getContent());
            Book book = bookRepo.findById(quoteView.getBookId())
                    .orElseThrow(() -> new BookException("Book not found with id: " + quoteView.getId()));
            quote.setBook(book);
            return quote;
        };
    }
}
