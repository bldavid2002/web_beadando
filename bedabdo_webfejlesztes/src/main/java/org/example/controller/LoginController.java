package org.example.controller;


import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/auth/login")
    public String login() {
        return "login";
    }

    @PostMapping("/auth/login")
    public String processlogin() {
        return "redirect:/books";
    }

    @GetMapping("/auth/registeration")
    public String goToRegisterationForm(Model model) {
        model.addAttribute("user", new User());
        return "registeration";
    }


    @PostMapping("/auth/saveuser")
    public  String processRegisteration(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);
        System.out.println(user);

        return "login";
    }
}
