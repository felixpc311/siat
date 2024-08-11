package com.adso.siat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class DocenteDTO {
    private final Long docenteId;
    private final String identificacion;
    private final String apellido1;
    private final String apellido2;
    private final String nombre1;
    private final String nombre2;
    private final String celular;
    private final String profesion;
}
