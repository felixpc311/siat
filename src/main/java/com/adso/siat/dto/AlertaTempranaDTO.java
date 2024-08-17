package com.adso.siat.dto;

import java.util.Date;

import com.adso.siat.models.AnioLectivoPeriodo;
import com.adso.siat.models.AsignacionAcademica;
import com.adso.siat.models.Matricula;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class AlertaTempranaDTO {

    private final Long alertaTempranaId;
    private final Matricula matricula;
    private final AsignacionAcademica asignacionAcademica;
    private final AnioLectivoPeriodo anioLectivoPeriodo;
    private final String descripcionAlerta;
    private final Date fechaAlerta;

}
