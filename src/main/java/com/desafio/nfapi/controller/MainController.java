package com.desafio.nfapi.controller;

import com.desafio.nfapi.date.DataDto;
import com.desafio.nfapi.entity.MainEntity;
import com.desafio.nfapi.service.MainService;
import com.desafio.nfapi.statusIndisp.StatusIndisp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    MainService service;

    @GetMapping(value = "/status")
    public List<MainEntity> status() throws IOException {
        return service.status();
    }

    @GetMapping(value = "/todosStatus")
    public List<MainEntity> todosStatus() {

        return service.todosStatus();
    }


    @GetMapping(value = "/statusAtual")
    public List<MainEntity> statusAtual() {

        return service.statusAtual();
    }

    @GetMapping(value = "/statusAtualEstado/{estado}")
    public List<MainEntity> statusAtualEstado(@PathVariable("estado") String estado) {

        return service.statusAtualEstado(estado);
    }

    @PostMapping("/data")
    public List<MainEntity> data(@RequestBody DataDto data) {

        return service.data(data);
    }

    @GetMapping("/instabilidade")
    public StatusIndisp instabilidade() {

        return service.instabilidade();

    }
}