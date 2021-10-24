package com.desafio.nfapi.service;

import com.desafio.nfapi.date.DataDto;
import com.desafio.nfapi.entity.MainEntity;
import com.desafio.nfapi.repository.MainRepository;
import com.desafio.nfapi.statusEnum.StatusEnum;
import com.desafio.nfapi.statusIndisp.StatusIndisp;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class MainService {
    @Autowired
    private MainRepository repository;

    public List<MainEntity> status() throws IOException {

        Document doc = Jsoup.connect("https://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx").get();

        Elements nomeEstado = doc.select("table.tabelaListagemDados").select("tbody > tr > td");

        int nomeIndex = 0;
        int statusIndex = 5;

        List<MainEntity> mainEntities = new ArrayList<>();

        for (int i=0; i<15; i++) {

            MainEntity mainEntity = new MainEntity();
            LocalDate dataAgora = LocalDate.now();

            mainEntity.setStatus(StatusEnum.recuperarPorNome(nomeEstado.get(statusIndex).select(("img")).attr("src")).getStatus());
            mainEntity.setData(dataAgora);
            mainEntity.setEstado(nomeEstado.get(nomeIndex).text());

            mainEntities.add(mainEntity);

            statusIndex +=9;
            nomeIndex +=9;

        }

        return  repository.saveAll(mainEntities);

    }

    public List<MainEntity> todosStatus() {

        return repository.findAll();

    }

    public List<MainEntity> statusAtual(){

        return repository.findTop15ByOrderByDataDesc();
    }

    public  List<MainEntity> statusAtualEstado(String estado){

        return repository.findFirstByEstadoOrderByDataDesc(estado);
    }

    public List<MainEntity> data(DataDto data){
        return repository.findTop15ByData(data.getData());
    }


    public StatusIndisp instabilidade() {

    List<StatusIndisp> statusIndispList = repository.instabilidade(StatusEnum.AMARELO.getStatus());

    Optional<StatusIndisp> maiorIndispOpcao =
            statusIndispList.stream().max(Comparator.comparing(StatusIndisp::getStatus));

        return maiorIndispOpcao.orElseThrow(NullPointerException:: new);

    }
}
