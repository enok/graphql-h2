package com.example.graphql_h2.book;

import lombok.Builder;

@Builder
record Author(Long id, String name) {
}
