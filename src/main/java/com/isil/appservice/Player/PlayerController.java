package com.isil.appservice.Player;


import com.isil.appservice.model.Info;
import com.isil.appservice.model.Results;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping({"/","/home","/player"})
public class PlayerController {
    private final RestTemplate restTemplate = new RestTemplate();
    public String index(){
        return "Hola";

    }

    @GetMapping("/otracosa")
    public String otraCosa(){
        return "hola, accediste al route otra cosa";
    }

    @GetMapping("/welcome")
    public String welcomeUser(@RequestParam(name ="user", defaultValue = "annon") String user){
        return "Hola, bienvenido "+user;
    }
    @GetMapping("/calculate")
    public int calculate(@RequestParam(name="num1", required = true) int num1,
                         @RequestParam(name="num2", required = true) int num2
                         ){
        return num1+num2;
    }
    @GetMapping("/personajes")
    public String calculate(){

        String url = "https://rickandmortyapi.com/api/character";
        Info response =   restTemplate.getForObject(url, Info.class);

        System.out.println(response);


        return response.toString();
    }
}
