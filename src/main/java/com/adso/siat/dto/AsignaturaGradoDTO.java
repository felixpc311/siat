package com.adso.siat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class AsignaturaGradoDTO {
    private final Long asignaturaGradoId;

    private final AsignaturaDTO asignatura;

    private final GradoDTO grado;

    

}
