package org.jnosql.example.domain;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;

@Entity
public class Author {
    @Column("first_name")
    private String firstName;
    @Column("last_name")
    private String lastName;
    @Column
    private String initials;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }
}
