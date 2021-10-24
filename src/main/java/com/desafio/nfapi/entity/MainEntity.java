package com.desafio.nfapi.entity;


import com.desafio.nfapi.statusEnum.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table (name = "NF")
@Getter
@Setter
public class MainEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="Estado")
    private String estado;

    @Column(name="Status")
    private String status;

    @Column(name = "Data")
    private LocalDate data;

}
