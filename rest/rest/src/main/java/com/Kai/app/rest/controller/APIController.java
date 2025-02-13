package com.Kai.app.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

    @GetMapping(value="/")
    public String getPage(){
        return "welcome";
    }
    
}
