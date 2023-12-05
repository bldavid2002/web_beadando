package org.example.service;

import org.example.dto.BookAuthorDto;
import org.example.dto.BookDto;
import org.example.model.AuthorModel;

import java.util.List;

public interface AuthorService {
    List<BookAuthorDto> findAll();

    BookAuthorDto saveAuthor(BookAuthorDto bookAuthorDto);

    BookAuthorDto findAuthorById(Integer id);
    BookAuthorDto updateBook(BookAuthorDto authorDto);
    void deleteAuthorById(int id);
}
