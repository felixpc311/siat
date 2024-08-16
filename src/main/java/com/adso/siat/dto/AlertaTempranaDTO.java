package com.adso.siat.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class AlertaTempranaDTO {

    private final Long alertaTempranaId;
    private final MatriculaDTO matricula;
    private final AsignacionAcademicaDTO asignacionAcademica;
    private final AnioLectivoPeriodoDTO anioLectivoPeriodo;
    private final String descripcionAlerta;
    private final Date fechaAlerta;

}
