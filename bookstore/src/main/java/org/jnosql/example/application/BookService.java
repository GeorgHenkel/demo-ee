package org.jnosql.example.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.jnosql.example.application.dto.BookDto;
import org.jnosql.example.domain.Book;
import org.jnosql.example.domain.BookRepository;

import java.util.List;

@ApplicationScoped
public class BookService {
    @Inject
    private BookRepository bookRepository;

    public List<Book> loadAll() {
        return bookRepository.findAll().toList();
    }

    public Book loadById(String id) {
        return bookRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Book loadByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(NotFoundException::new);
    }

    public Book addBook(BookDto bookInput) {
        return bookRepository.save(bookInput.mapToEntity());
    }
}
