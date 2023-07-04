package org.jnosql.example.infrastructure.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jnosql.example.application.BookService;
import org.jnosql.example.application.dto.BookDto;

@Path("books")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class BookResource {
    @Inject
    private BookService bookService;

    @GET
    public Response getAll() {
        var books = bookService.loadAll();
        return Response.ok(books).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") String id) {
        var book = bookService.loadById(id);
        return Response.ok(book).build();
    }

    @GET
    @Path("/isbn/{isbn}")
    public Response getByIsbn(@PathParam("isbn") String isbn) {
        var book = bookService.loadByIsbn(isbn);
        return Response.ok(book).build();
    }

    @POST
    public Response add(BookDto dto) {
        var book = bookService.addBook(dto);
        return Response.ok(book).build();
    }
}
