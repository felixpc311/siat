package com.adso.siat.dto;

import java.util.Date;

import com.adso.siat.models.AnioLectivo;
import com.adso.siat.models.PeriodoAcademico;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class AnioLectivoPeriodoDTO {

    private final Long anioLectivoPeriodoId;
    private final AnioLectivo anioLectivo;
    private final PeriodoAcademico periodoAcademico;
    private final Date fechaInicio;
    private final Date fechaFin;
}
