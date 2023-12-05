package org.example.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "Author")
public class AuthorModel {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "NEV")
    private String name;
    @Column(name = "ORIGIN")
    private String origin;
    @Column(name = "ERA")
    private int era;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<BookModel> books = new ArrayList<>();


    public AuthorModel() {
    }

    public AuthorModel(int id, String name, String origin, int era, List<BookModel> books) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.era = era;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getEra() {
        return era;
    }

    public void setEra(int era) {
        this.era = era;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorModel that = (AuthorModel) o;
        return id == that.id && era == that.era && Objects.equals(name, that.name) && Objects.equals(origin, that.origin) && Objects.equals(books, that.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, origin, era, books);
    }

    @Override
    public String toString() {
        return "AuthorModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", era=" + era +
                ", books=" + books +
                '}';
    }
}

