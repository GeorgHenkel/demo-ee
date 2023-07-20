package org.jnosql.example.domain;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;

@Entity
public record Author(
        @Column("first_name")
        String firstName,
        @Column("last_name")
        String lastName
) {
}
