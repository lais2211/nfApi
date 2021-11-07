package com.desafio.nfapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {

    @RequestMapping(value = "/custom", method = RequestMethod.POST)
    public Integer custom() {
        return 1;
    }
}

