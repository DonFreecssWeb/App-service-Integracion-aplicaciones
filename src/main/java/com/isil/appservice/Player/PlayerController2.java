package com.isil.appservice.Player;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping({"/"})
public class PlayerController2 {

    public static void main(String[] args) {
        File file = new File("e:\\isil\\a.txt");
        StringBuilder stringBuilder = new StringBuilder();
/*
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.append("Hola");
            fileWriter.close();

            String a;
            String b;
            FileReader fileReader  = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ( (a = bufferedReader.readLine()) != null){
                System.out.println(a);
            }

            Scanner s = new Scanner(file);
            while (s.hasNext()){
             b =   s.nextLine();
                System.out.println(b);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
*/


    }
/*
    @GetMapping({"/index","/","/player"})
    public String index(Model model){
        model.addAttribute("titulo","Titulo desde el model");
        return "indexxxx";
    }

    @GetMapping("/welcome")
    public String welcomeUser(@RequestParam(name = "user", defaultValue =  "aaaa") String user ){
        return "Hola bienvenido "+user;


    }
      */

}
