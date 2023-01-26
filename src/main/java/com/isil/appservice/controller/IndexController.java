package com.isil.appservice.controller;


import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {

    @GetMapping({"/"})
    public String index(){
        return "index";
    }

}
