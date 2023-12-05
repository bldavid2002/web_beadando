package org.example.service;

import org.example.dto.BookAuthorDto;
import org.example.dto.BookDto;
import org.example.model.AuthorModel;
import org.example.model.BookModel;

import java.util.List;

public interface BookService {


    BookDto findBookById(Integer id);

    BookDto saveBook(BookDto bookDto);

    List<BookDto> findAllBookByQuantity(int quantity);

    BookDto updateBook(BookDto bookDto);

    List<BookDto> findAllBookByTitle(String title);

    List<BookDto>  findAllBookByPrice(int price);

    List<BookAuthorDto> findAllAuthorOrigin();

    void deleteBookById(int id);
}

