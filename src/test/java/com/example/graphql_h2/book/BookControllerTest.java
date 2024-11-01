package com.example.graphql_h2.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureHttpGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureHttpGraphQlTester
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class BookControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void canGetAllBooks() {
        GraphQlTester.EntityList<Book> bookEntityList = graphQlTester
                .documentName("books")
                .execute()
                .path("allBooks")
                .entityList(Book.class)
                .hasSize(3)
                .containsExactly(
                        BookService.BOOKS.get(0),
                        BookService.BOOKS.get(1),
                        BookService.BOOKS.get(2)
                );

        assertThat(bookEntityList.get()).hasSize(3);
    }

    @Test
    void canGetABookById() {
        GraphQlTester.Entity<Book, ?> book = graphQlTester
                .documentName("books")
                .execute()
                .path("bookById")
                .entity(Book.class)
                .isEqualTo(BookService.BOOKS.getFirst());

        assertThat(book).isNotNull();
    }
}
