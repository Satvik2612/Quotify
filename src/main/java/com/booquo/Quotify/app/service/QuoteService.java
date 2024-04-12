package com.booquo.Quotify.app.service;

import com.booquo.Quotify.app.entity.Quote;
import com.booquo.Quotify.app.repo.QuoteRepo;
import com.booquo.Quotify.app.transformer.QuoteTransformer;
import com.booquo.Quotify.app.view.QuoteView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuoteService {
    private final QuoteRepo quoteRepo;

    private final QuoteTransformer quoteTransformer;

    public QuoteView saveQuote(QuoteView quoteView) {
        Quote quote = quoteTransformer.toEntity().apply(quoteView);
        Quote savedQuote = quoteRepo.save(quote);
        return quoteTransformer.toView().apply(savedQuote);
    }

    public List<QuoteView> getAllQuotes() {
        List<Quote> quotes = quoteRepo.findAll();
        return quotes.stream().map(quoteTransformer.toView()).collect(Collectors.toList());
    }
}
