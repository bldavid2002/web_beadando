package org.example.service.mapper;


import org.example.dto.BookAuthorDto;
import org.example.dto.BookDto;
import org.example.model.AuthorModel;
import org.example.model.BookModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper (componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "dtoid", source = "id")
    @Mapping(target = "dtotitle", source = "title")
    @Mapping(target = "dtoquantity", source = "quantity")
    @Mapping(target = "dtoprice", source = "price")
    @Mapping(target = "dtoauthorId" , source ="author.id" )
    BookDto bookModelToBookDto(BookModel bookModel);

    @Mapping(target = "id", source = "dtoid")
    @Mapping(target = "title", source = "dtotitle")
    @Mapping(target = "quantity", source = "dtoquantity")
    @Mapping(target = "price", source = "dtoprice")
    @Mapping(target = "author.id" , source ="dtoauthorId" )
    BookModel bookDtoToBookModel(BookDto bookDto);

    List<BookModel> bookDtoListToEntityList(List<BookDto> bookDtos);


    BookAuthorDto bookEntityToAuthorDto(BookModel bookModel);

    List<BookDto> bookEntityListToDtoList(List<BookModel> books);

    default Integer map(AuthorModel authorModel) {
        return authorModel != null ? authorModel.getId() : null;
    }

    default String mapOrigin(AuthorModel authorModel) {
        return authorModel != null ? authorModel.getOrigin() : null;
    }

    List<BookAuthorDto> bookEntityListToAuthorDto(List<BookModel> bookModels);
}
