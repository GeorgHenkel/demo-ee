package org.jnosql.example.application.dto;

import org.jnosql.example.domain.Author;
import org.jnosql.example.domain.Book;

import java.util.Date;
import java.util.List;

public record BookDto(String isbn, String title, Date published, String edition, List<Author> authors) {
    public Book mapToEntity() {
        var book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setPublished(published);
        book.setEdition(edition);
        book.setAuthors(authors);

        return book;
    }
}
