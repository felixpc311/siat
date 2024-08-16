package com.adso.siat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class AsignaturaDTO {

    private final Long asignaturaId;
    private final String asignaturaNombre;

}
