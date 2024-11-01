package com.example.graphql_h2.book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
class BookService {
    public static final List<Book> BOOKS = new ArrayList<>();

    public List<Book> findAll() {
        if (!BOOKS.isEmpty()) {
            return BOOKS;
        }

        Author tolkien = Author.builder()
                .id(123L)
                .name("Tolkien")
                .build();

        Author uncleBob = Author.builder()
                .id(456L)
                .name("Uncle Bob")
                .build();

        List<Book> books = List.of(
                Book.builder().id(111L).name("Lord of The Rings").author(tolkien).pageCount(1000).build(),
                Book.builder().id(222L).name("The Hobbit").author(tolkien).pageCount(800).build(),
                Book.builder().id(333L).name("The Clean Code").author(uncleBob).pageCount(300).build()
        );

        BOOKS.addAll(books);

        return BOOKS;
    }

    public Optional<Book> findById(Long id) {
        return findAll().stream()
                .filter(b -> b.id().equals(id))
                .findFirst();
    }
}
