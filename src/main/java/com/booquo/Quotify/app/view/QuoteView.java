package com.booquo.Quotify.app.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuoteView {
    private Long id;
    private String content;
    private Long bookId;
}
