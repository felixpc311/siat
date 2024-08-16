package com.adso.siat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class GradoDTO {

    private final Long gradoId;
    private final String grado;
    private final String gradoCodigo;

}
