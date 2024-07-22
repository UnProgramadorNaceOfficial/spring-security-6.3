package com.security.presentation.controller;

import com.security.persistence.entity.Person;
import com.security.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final PersonService personService;

    @GetMapping("/admin")
    public String sayHelloAdmin() {
        return "Hello World Admin";
    }

    @GetMapping("/user")
    public String sayHelloUser() {
        return "Hello World User";
    }

    @GetMapping("/invited")
    public String sayHelloInvited() {
        return "Hello World Invited";
    }

    @GetMapping("/find")
    public Person findById(){
        return this.personService.findById().orElseThrow();
    }

    @GetMapping("/findAll")
    public List<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password){
        return "";
    }
}
