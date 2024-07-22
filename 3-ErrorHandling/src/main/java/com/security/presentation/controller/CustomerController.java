package com.security.presentation.controller;

import com.security.configuration.exception.SecurityErrorHandler;
import com.security.persistence.entity.Person;
import com.security.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.security.authorization.method.HandleAuthorizationDenied;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AuthorizeReturnObject
@RequiredArgsConstructor
@HandleAuthorizationDenied(handlerClass = SecurityErrorHandler.class)
public class CustomerController {

    private final PersonService personService;

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    // @HandleAuthorizationDenied(handlerClass = SecurityErrorHandler.class)
    public String sayHelloAdmin() {
        return "Hello World Admin";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    //  @HandleAuthorizationDenied(handlerClass = SecurityErrorHandler.class)
    public String sayHelloUser() {
        return "Hello World User";
    }

    @GetMapping("/invited")
    @PreAuthorize("hasRole('INVITED')")
    // @HandleAuthorizationDenied(handlerClass = SecurityErrorHandler.class)
    public String sayHelloInvited() {
        return "Hello World Invited";
    }

    @GetMapping("/find")
    public Person findById() {
        return this.personService.findById().orElseThrow();
    }

    @GetMapping("/findAll")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password){
        return "";
    }
}
