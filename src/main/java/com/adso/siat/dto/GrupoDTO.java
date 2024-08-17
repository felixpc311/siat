package com.adso.siat.dto;

import com.adso.siat.models.Grado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class GrupoDTO {
    
    private final Long grupoId;
    private final Grado grado;
    private final String grupoCodigo;


}
