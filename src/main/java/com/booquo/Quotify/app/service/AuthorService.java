package com.booquo.Quotify.app.service;

import com.booquo.Quotify.app.entity.Author;
import com.booquo.Quotify.app.repo.AuthorRepo;
import com.booquo.Quotify.app.transformer.AuthorTransformer;
import com.booquo.Quotify.app.view.AuthorView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepo authorRepo;

    private final AuthorTransformer authorTransformer;

    public AuthorView saveAuthor(AuthorView authorView) {
        Author author = authorTransformer.toEntity().apply(authorView);
        Author savedAuthor = authorRepo.save(author);
        return authorTransformer.toView().apply(savedAuthor);
    }

    public List<AuthorView> getAllAuthors() {
        List<Author> authors = authorRepo.findAll();
        return authors.stream().map(authorTransformer.toView()).collect(Collectors.toList());
    }
}
