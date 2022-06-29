package com.example.Myrecipes.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/Myrecipes")
public class MainController {

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ResponseEntity<String> hello(){
         return ResponseEntity.ok("Hello world!");
    }
}
