package com.adso.siat.dto;

import com.adso.siat.models.Alumno;
import com.adso.siat.models.AnioLectivo;
import com.adso.siat.models.Grupo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class MatriculaDTO {
    private final Long matriculaId;
    private final AnioLectivo anioLectivo;
    private final Alumno alumno;
    private final Grupo grupo;
}
