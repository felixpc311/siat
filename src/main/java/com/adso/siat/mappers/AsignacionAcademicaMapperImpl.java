package com.adso.siat.mappers;

import java.util.List;

import com.adso.siat.dto.AsignacionAcademicaDTO;
import com.adso.siat.models.AsignacionAcademica;

public class AsignacionAcademicaMapperImpl implements IAsignacionAcademicaMapper {

    @Override
    public void updateAsignacionAcademica(AsignacionAcademica asignacionAcademica,
            AsignacionAcademicaDTO asignacionAcademicaDTO) {
        if (asignacionAcademicaDTO == null) {
            return;
        }
        asignacionAcademica.setAsignacionAcademicaId(asignacionAcademicaDTO.getAsignacionAcademicaId());
        asignacionAcademica.setAnioLectivo(asignacionAcademicaDTO.getAnioLectivo());
        asignacionAcademica.setDocente(asignacionAcademicaDTO.getDocente());
        asignacionAcademica.setGrupo(asignacionAcademicaDTO.getGrupo());
        asignacionAcademica.setAsignaturaGrado(asignacionAcademicaDTO.getAsignaturaGrado());
    }

    @Override
    public AsignacionAcademicaDTO mapToAsignacionAcademicaDTO(AsignacionAcademica asignacionAcademica) {
        if (asignacionAcademica == null) {
            return null;
            
        }

        return AsignacionAcademicaDTO.builder()
                .asignacionAcademicaId(asignacionAcademica.getAsignacionAcademicaId())
                .anioLectivo(asignacionAcademica.getAnioLectivo())
                .docente(asignacionAcademica.getDocente())
                .grupo(asignacionAcademica.getGrupo())
                .asignaturaGrado(asignacionAcademica.getAsignaturaGrado())
                .build();
    }

    @Override
    public List<AsignacionAcademicaDTO> mapToAsignacionAcademicaDTOList(
            List<AsignacionAcademica> asignacionAcademicaList) {
        if (asignacionAcademicaList == null) {
            return null;
        }

        List<AsignacionAcademicaDTO> list = asignacionAcademicaList.stream()
                .map(this::mapToAsignacionAcademicaDTO).toList();
        return list;
    }

    @Override
    public AsignacionAcademica mapToAsignacionAcademica(AsignacionAcademicaDTO asignacionAcademicaDTO) {
        if (asignacionAcademicaDTO == null) {
            return null;
        }

        return AsignacionAcademica.builder()
                .asignacionAcademicaId(asignacionAcademicaDTO.getAsignacionAcademicaId())
                .anioLectivo(asignacionAcademicaDTO.getAnioLectivo())
                .docente(asignacionAcademicaDTO.getDocente())
                .grupo(asignacionAcademicaDTO.getGrupo())
                .asignaturaGrado(asignacionAcademicaDTO.getAsignaturaGrado())
                .build();
    }

}
