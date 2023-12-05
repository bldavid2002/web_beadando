package org.example.service.mapper;

import org.example.dto.BookAuthorDto;
import org.example.model.AuthorModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Mapping(target = "authorId", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "origin", source = "origin")
    BookAuthorDto authorModelToAuthorDto(AuthorModel author);

    List<BookAuthorDto> authorModelListToAuthorDtoList(List<AuthorModel> authors);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    AuthorModel authorDtoToAuthorModel(BookAuthorDto authorDto);

    List<AuthorModel> authorDtoListToAuthorModelList(List<BookAuthorDto> authorDtos);
}