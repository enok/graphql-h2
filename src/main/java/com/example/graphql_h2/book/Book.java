package com.example.graphql_h2.book;

import lombok.Builder;

@Builder
record Book(Long id, String name, int pageCount, Author author) {
}
