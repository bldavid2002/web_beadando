package org.example.controller;

import org.example.dto.BookDto;
import org.example.model.AuthorModel;
import org.example.model.BookModel;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.print.Book;

@Controller
public class BookController {
    @Autowired
    BookService service;

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/logedin/books")
    public String findAll(Model model){
        model.addAttribute("books",bookRepository.findAll());
        return "all-books";
    }




    @GetMapping("/logedin/editBook/{id}")
    public String goToEditPage(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", service.findBookById(id));
        return "edit-book";

    }

    @PostMapping("/logedin/updatebook")
    public String upadteBook(BookDto bookDto) {
        service.updateBook(bookDto);
        return "redirect:/logedin/books";
    }

    @GetMapping("/logedin/addbook")
    public String goToAddBookPage(Model model){
        model.addAttribute("book",new BookDto());
        return "add-book";
    }

    @PostMapping("/logedin/addbooksave")
    public String addBook(BookDto bookDto){
        service.saveBook(bookDto);
        return "redirect:/logedin/books";
    }

    @GetMapping("/logedin/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        service.deleteBookById(id);
        return "redirect:/logedin/books";
    }

    @GetMapping("/test")
    public String test(){
        BookDto bk = new BookDto();
        service.saveBook(bk);
        return "index";
    }

}
