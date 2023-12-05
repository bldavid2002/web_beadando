package org.example.service.impl;

import org.example.dto.BookAuthorDto;
import org.example.model.AuthorModel;
import org.example.repository.AuthorRepository;
import org.example.service.AuthorService;
import org.example.service.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    AuthorMapper authorMapper;
    @Override
    public List<BookAuthorDto> findAll() {
        return authorMapper.authorModelListToAuthorDtoList(authorRepository.findAll());
    }

    @Override
    public BookAuthorDto saveAuthor(BookAuthorDto bookAuthorDto) {
        AuthorModel entity = authorMapper.authorDtoToAuthorModel(bookAuthorDto);
        entity = authorRepository.save(entity);

        return  authorMapper.authorModelToAuthorDto(entity);
    }

    @Override
    public BookAuthorDto findAuthorById(Integer id) {
       return authorMapper.authorModelToAuthorDto(authorRepository.getReferenceById(id));
    }

    @Override
    public BookAuthorDto updateBook(BookAuthorDto authorDto) {
        Optional<AuthorModel> result = Optional.ofNullable(authorRepository.findById(authorDto.getAuthorId()));
        if (result.isPresent()) {
            AuthorModel existing = result.get();
            existing.setOrigin(authorDto.getOrigin());
            existing.setName(authorDto.getName());
            existing.setEra(authorDto.getEra());

            return authorMapper.authorModelToAuthorDto(authorRepository.save(existing));
        } else {

            throw new RuntimeException("Nem található rekord az azonosítóval: " + authorDto.getAuthorId());
        }
    }

    @Override
    public void deleteAuthorById(int id) {
        System.out.println(id);
        authorRepository.deleteById(id);
    }


}
