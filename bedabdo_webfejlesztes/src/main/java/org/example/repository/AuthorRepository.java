package org.example.repository;

import org.example.model.AuthorModel;
import org.example.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorModel,Integer> {
    AuthorModel findById(int id);
}
