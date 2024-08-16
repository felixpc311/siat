package com.adso.siat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class MatriculaDTO {
    private final Long matriculaId;
    private final AnioLectivoDTO anioLectivo;
    private final AlumnoDTO alumno;
    private final GrupoDTO grupo;
}
