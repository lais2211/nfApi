package com.desafio.nfapi.util;

import com.desafio.nfapi.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StatusHistorico {

    @Autowired
    MainService service;

    @Scheduled(fixedRate = 300000)
    public void timer () throws IOException {

        service.status();

    }

}
