package org.jnosql.example.domain;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
    Optional<Book> findByIsbn(String isbn);
}
