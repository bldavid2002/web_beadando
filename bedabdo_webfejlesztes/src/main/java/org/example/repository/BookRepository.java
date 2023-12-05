package org.example.repository;

import org.example.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<BookModel,Integer> {

    List<BookModel> findAllByQuantity(int quantity);

    List<BookModel> findAllByPrice(int price);

    List<BookModel> findAllByTitleEqualsIgnoreCase(String title);
}
