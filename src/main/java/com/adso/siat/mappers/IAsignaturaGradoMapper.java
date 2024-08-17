package com.adso.siat.mappers;

import java.util.List;

import com.adso.siat.dto.AsignaturaGradoDTO;
import com.adso.siat.models.AsignaturaGrado;

public interface IAsignaturaGradoMapper {

    public void updateAsignaturaGrado(AsignaturaGrado asignaturaGrado, AsignaturaGradoDTO asignaturaGradoDTO);

    public AsignaturaGradoDTO mapToAsignaturaGradoDTO(AsignaturaGrado asignaturaGrado);

    public List<AsignaturaGradoDTO> mapToAsignaturaGradoDTOList(List<AsignaturaGrado> asignaturaGradoList);

    public AsignaturaGrado mapToAsignaturaGrado(AsignaturaGradoDTO asignaturaGradoDTO);
}
