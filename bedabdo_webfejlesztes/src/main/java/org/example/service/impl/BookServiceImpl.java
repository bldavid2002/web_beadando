package org.example.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.dto.BookAuthorDto;
import org.example.dto.BookDto;
import org.example.model.AuthorModel;
import org.example.model.BookModel;
import org.example.repository.AuthorRepository;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.example.service.mapper.AuthorMapper;
import org.example.service.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    BookRepository bookResporsitory;
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookMapper bookMapper;

    @Autowired
    AuthorMapper authorMapper;



    @Override
    public BookDto findBookById(Integer id) {
        return  bookMapper.bookModelToBookDto(bookResporsitory.getReferenceById(id));
    }

    @Transactional
    @Override
    public BookDto saveBook(BookDto bookDto) {
        System.out.println("Mapping BookDto to BookModel: " + bookDto);
        BookModel bookModel = bookMapper.bookDtoToBookModel(bookDto);
        System.out.println("Mapped BookModel: " + bookModel);

        if (bookDto.getDtoauthorId() != 0) {
            AuthorModel existingAuthor = authorRepository.findById(bookDto.getDtoauthorId());

            if (existingAuthor != null) {
                bookModel.setAuthor(existingAuthor);

                if (bookModel.getId() == 0) {
                    bookModel = bookResporsitory.save(bookModel);
                } else {
                    existingAuthor = entityManager.merge(existingAuthor);
                    bookModel = entityManager.merge(bookModel);
                }

                return bookMapper.bookModelToBookDto(bookModel);
            }
        }
        return null;

    }

    @Override
    public List<BookDto> findAllBookByQuantity(int quantity) {
        List<BookModel> entites = bookResporsitory.findAllByQuantity(quantity);
        List<BookDto> dtos = bookMapper.bookEntityListToDtoList(entites);

        return dtos;
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        Optional<BookModel> result = bookResporsitory.findById(bookDto.getDtoid());
        if (result.isPresent()) {
            BookModel existing = result.get();
            existing.setTitle(bookDto.getDtotitle());
            existing.setPrice(bookDto.getDtoprice());
            existing.setQuantity(bookDto.getDtoquantity());

            return bookMapper.bookModelToBookDto(bookResporsitory.save(existing));
        } else {

            throw new RuntimeException("Nem található rekord az azonosítóval: " + bookDto.getDtoid());
        }
    }


    @Override
    public List<BookDto> findAllBookByTitle(String title) {
        List<BookModel> entites = bookResporsitory.findAllByTitleEqualsIgnoreCase(title);
        List<BookDto> dtos = bookMapper.bookEntityListToDtoList(entites);
        return dtos;
    }


    @Override
    public List<BookDto> findAllBookByPrice(int price) {
        List<BookModel> entites = bookResporsitory.findAllByPrice(price);
        List<BookDto> dtos = bookMapper.bookEntityListToDtoList(entites);

        return dtos;
    }

    @Override
    public List<BookAuthorDto> findAllAuthorOrigin() {
        return bookMapper.bookEntityListToAuthorDto(bookResporsitory.findAll());
    }

    @Override
    public void deleteBookById(int id) {
        System.out.println(id);
        bookResporsitory.deleteById(id);
    }
}
