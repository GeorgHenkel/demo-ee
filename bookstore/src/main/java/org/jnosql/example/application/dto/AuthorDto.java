package org.jnosql.example.application.dto;

import org.jnosql.example.domain.Author;

public record AuthorDto(String firstName, String lastName, String initials) {
    public Author mapToEntity() {
        var author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setInitials(initials);

        return author;
    }
}
