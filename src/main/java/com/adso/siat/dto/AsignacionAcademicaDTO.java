package com.adso.siat.dto;

import com.adso.siat.models.AnioLectivo;
import com.adso.siat.models.AsignaturaGrado;
import com.adso.siat.models.Docente;
import com.adso.siat.models.Grupo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class AsignacionAcademicaDTO {
    private final Long asignacionAcademicaId;

    private final AnioLectivo anioLectivo;
    private final Docente docente;
    private final Grupo grupo;
    private final AsignaturaGrado asignaturaGrado;
}
