package com.adso.siat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class AsignacionAcademicaDTO {
    private final Long asignacionAcademicaId;

    private final AnioLectivoDTO anioLectivo;
    private final DocenteDTO docente;
    private final GrupoDTO grupo;
    private final AsignaturaGradoDTO asignaturaGrado;
}
