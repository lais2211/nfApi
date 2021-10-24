package com.desafio.nfapi.statusEnum;

import lombok.Getter;

@Getter
public enum StatusEnum {

    VERDE("Disponivel","verde","imagens/bola_verde_P.png"),
    AMARELO("Indisponivel","amarelo","imagens/bola_amarela_P.png"),

    VERMELHO("Indisponivel","vermelho","imagens/bola_vermelho_P.png");

    private String id;
    private String status;
    private String nome;

    StatusEnum(String id, String status, String nome) {
        this.id = id;
        this.status = status;
        this.nome = nome;
    }

    public static StatusEnum recuperarPorNome (String n) {
        for (StatusEnum code: StatusEnum.values()){
            if (code.getNome().equals(n)){
                return code;
            }
        }
        return null;
    }

}
