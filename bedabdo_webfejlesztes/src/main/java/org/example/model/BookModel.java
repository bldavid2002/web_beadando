package org.example.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "BOOK")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "TITLE", unique = true)
    private String title;
    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "PRICE")
    private int price;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "AUTHOR_ID",referencedColumnName = "id")
    private AuthorModel author;




    public BookModel() {
    }


    public BookModel(int id, String title, int quantity, int price, AuthorModel author) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookModel bookModel = (BookModel) o;
        return id == bookModel.id && quantity == bookModel.quantity && price == bookModel.price && Objects.equals(title, bookModel.title) && Objects.equals(author, bookModel.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, quantity, price, author);
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", author=" + author +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public AuthorModel getAuthor() {
        return author;
    }

    public void setAuthor(AuthorModel author) {
        this.author = author;
    }
}


