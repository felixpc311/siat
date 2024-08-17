package com.adso.siat.mappers;

import java.util.List;

import com.adso.siat.dto.AsignaturaDTO;
import com.adso.siat.models.Asignatura;

public interface IAsignaturaMapper {
    public void updateAsignatura(Asignatura asignatura, AsignaturaDTO asignaturaDTO);

    public AsignaturaDTO mapToAsignaturaDTO(Asignatura asignatura);

    public List<AsignaturaDTO> mapToAsignaturaDTOList(List<Asignatura> asignaturaList);

    public Asignatura mapToAsignatura(AsignaturaDTO asignaturaDTO);

}
