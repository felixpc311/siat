package com.adso.siat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PeriodoAcademicoDTO {

    private final Long peridoAcademicoId;
    private final int periodoAcademicoNumero;
}
