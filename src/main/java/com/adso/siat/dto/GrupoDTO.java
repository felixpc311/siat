package com.adso.siat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class GrupoDTO {
    
    private final Long grupoId;
    private final GradoDTO gradoDTO ;
    private final String grupoCodigo;


}
