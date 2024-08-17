package com.adso.siat.mappers;

import java.util.List;

import com.adso.siat.dto.AsignaturaGradoDTO;
import com.adso.siat.models.AsignaturaGrado;

public class AsignaturaGradoMapperImpl implements IAsignaturaGradoMapper {

    @Override
    public void updateAsignaturaGrado(AsignaturaGrado asignaturaGrado, AsignaturaGradoDTO asignaturaGradoDTO) {
        if (asignaturaGradoDTO == null) {
            return;
        }

        asignaturaGrado.setAsignaturaGradoId(asignaturaGradoDTO.getAsignaturaGradoId());
        asignaturaGrado.setAsignatura(asignaturaGradoDTO.getAsignatura());
        asignaturaGrado.setGrado(asignaturaGradoDTO.getGrado());
    }

    @Override
    public AsignaturaGradoDTO mapToAsignaturaGradoDTO(AsignaturaGrado asignaturaGrado) {
        if (asignaturaGrado == null) {
            return null;
        }

        return AsignaturaGradoDTO.builder()
                .asignaturaGradoId(asignaturaGrado.getAsignaturaGradoId())
                .asignatura(asignaturaGrado.getAsignatura())
                .grado(asignaturaGrado.getGrado())
                .build();
    }

    @Override
    public List<AsignaturaGradoDTO> mapToAsignaturaGradoDTOList(List<AsignaturaGrado> asignaturaGradoList) {
        if (asignaturaGradoList == null) {
            return null;
        }

        List<AsignaturaGradoDTO> list = asignaturaGradoList.stream()
                .map(this::mapToAsignaturaGradoDTO)
                .toList();
        return list;
    }

    @Override
    public AsignaturaGrado mapToAsignaturaGrado(AsignaturaGradoDTO asignaturaGradoDTO) {
        if (asignaturaGradoDTO == null) {
            return null;
        }

        return AsignaturaGrado.builder()
                .asignaturaGradoId(asignaturaGradoDTO.getAsignaturaGradoId())
                .asignatura(asignaturaGradoDTO.getAsignatura())
                .grado(asignaturaGradoDTO.getGrado())
                .build();
    }

}
