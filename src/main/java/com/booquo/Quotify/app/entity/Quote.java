package com.booquo.Quotify.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quote")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
