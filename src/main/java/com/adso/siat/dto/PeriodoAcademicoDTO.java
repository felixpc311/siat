package com.adso.siat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PeriodoAcademicoDTO {

    private final Long peridoAcademicoIdDTO;
    private final int periodoAcademicoNumeroDTO;
}
