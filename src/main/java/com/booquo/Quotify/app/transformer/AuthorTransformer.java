package com.booquo.Quotify.app.transformer;

import com.booquo.Quotify.app.entity.Author;
import com.booquo.Quotify.app.view.AuthorView;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AuthorTransformer {
    public Function<Author, AuthorView> toView() {
        return author -> {
            AuthorView authorView = new AuthorView();
            authorView.setId(author.getId());
            authorView.setName(author.getName());
            return authorView;
        };
    }

    public Function<AuthorView, Author> toEntity() {
        return authorView -> {
            Author author = new Author();
            author.setName(authorView.getName());
            return author;
        };
    }
}
