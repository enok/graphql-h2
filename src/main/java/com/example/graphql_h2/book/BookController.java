package com.example.graphql_h2.book;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
class BookController {

    private final BookService bookService;

    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    List<Book> allBooks() {
        return bookService.findAll();
    }

    @QueryMapping
    Optional<Book> bookById(@Argument Long id) {
        return bookService.findById(id);
    }
}
