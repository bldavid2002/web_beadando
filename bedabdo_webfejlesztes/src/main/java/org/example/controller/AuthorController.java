package org.example.controller;


import org.example.dto.BookAuthorDto;
import org.example.dto.BookDto;
import org.example.model.AuthorModel;
import org.example.model.BookModel;
import org.example.service.AuthorService;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

    @Autowired
    AuthorService service;


    @GetMapping("/logedin/authors")
    public String findAll(Model model){
        model.addAttribute("authors",service.findAll());
        return "all-author";
    }

    @PostMapping("/logedin/addauthorsave")
    public String addAuthor(BookAuthorDto authorDto){
        service.saveAuthor(authorDto);
        return "redirect:/logedin/authors";
    }


    @GetMapping("/logedin/addauthor")
    public String goToAddAuthorPage(Model model){
        model.addAttribute("author",new AuthorModel());
        return "add-author";
    }


    @GetMapping("/logedin/editAuthor/{id}")
    public String goToEditAuthorPage(Model model, @PathVariable("id") int id) {
        model.addAttribute("author", service.findAuthorById(id));
        return "edit-Author";

    }

    @PostMapping("/logedin/updatauthor")
    public String upadteAuthor(BookAuthorDto authorDto) {
        service.updateBook(authorDto);
        return "redirect:/logedin/authors";
    }


    @GetMapping("/logedin/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable("id") int id) {
        service.deleteAuthorById(id);
        return "redirect:/logedin/authors";
    }


    @GetMapping("/testAuthor")
    public String test(){
        BookAuthorDto at = new BookAuthorDto();

        at.setName("JASDASDASD");
        at.setEra(2000);
        at.setOrigin("ENGLEAND");

        service.saveAuthor(at);
        return "index";
    }
}
