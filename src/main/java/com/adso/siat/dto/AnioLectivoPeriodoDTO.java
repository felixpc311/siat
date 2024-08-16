package com.adso.siat.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class AnioLectivoPeriodoDTO {

    private final Long anioLectivoPeriodoId;
    private final AnioLectivoDTO anioLectivo;
    private final PeriodoAcademicoDTO periodoAcademico;
    private final Date fechaInicio;
    private final Date fechaFin;
}
