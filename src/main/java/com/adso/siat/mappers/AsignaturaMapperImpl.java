package com.adso.siat.mappers;

import java.util.List;

import com.adso.siat.dto.AsignaturaDTO;
import com.adso.siat.models.Asignatura;

public class AsignaturaMapperImpl implements IAsignaturaMapper {

    @Override
    public void updateAsignatura(Asignatura asignatura, AsignaturaDTO asignaturaDTO) {
        if (asignaturaDTO == null) {
            return;
        }

        asignatura.setAsignaturaId(asignaturaDTO.getAsignaturaId());
        asignatura.setAsignaturaNombre(asignaturaDTO.getAsignaturaNombre());
        
    }

    @Override
    public AsignaturaDTO mapToAsignaturaDTO(Asignatura asignatura) {
        if (asignatura == null) {
            return null;
        }

        return AsignaturaDTO.builder()
                .asignaturaId(asignatura.getAsignaturaId())
                .asignaturaNombre(asignatura.getAsignaturaNombre())
                .build();
    }

    @Override
    public List<AsignaturaDTO> mapToAsignaturaDTOList(List<Asignatura> asignaturaList) {
        if (asignaturaList == null) {
            return null;
        }

        List<AsignaturaDTO> list = asignaturaList.stream()
                .map(this::mapToAsignaturaDTO).toList();
        return list;
    }

    @Override
    public Asignatura mapToAsignatura(AsignaturaDTO asignaturaDTO) {
        if (asignaturaDTO == null) {
            return null;
        }

        return Asignatura.builder()
                .asignaturaId(asignaturaDTO.getAsignaturaId())
                .asignaturaNombre(asignaturaDTO.getAsignaturaNombre())
                .build();
    }

}
