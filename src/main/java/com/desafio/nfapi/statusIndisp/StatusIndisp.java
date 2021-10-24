package com.desafio.nfapi.statusIndisp;

import com.desafio.nfapi.statusEnum.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StatusIndisp {
    private String estado;
    private Long status;

}
