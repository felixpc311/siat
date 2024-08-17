package com.adso.siat.dto;

import com.adso.siat.models.Asignatura;
import com.adso.siat.models.Grado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class AsignaturaGradoDTO {
    private final Long asignaturaGradoId;

    private final Asignatura asignatura;

    private final Grado grado;

    

}
