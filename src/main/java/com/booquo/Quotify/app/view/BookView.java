package com.booquo.Quotify.app.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookView {
    private Long id;
    private String title;
    private List<AuthorView> authors;
    private List<QuoteView> quotes;
}
