package com.adso.siat.mappers;

import java.util.List;

import com.adso.siat.dto.AsignacionAcademicaDTO;
import com.adso.siat.models.AsignacionAcademica;

public interface IAsignacionAcademicaMapper {

    public void updateAsignacionAcademica(AsignacionAcademica asignacionAcademica, AsignacionAcademicaDTO asignacionAcademicaDTO);

    public AsignacionAcademicaDTO mapToAsignacionAcademicaDTO(AsignacionAcademica asignacionAcademica);

    public List<AsignacionAcademicaDTO> mapToAsignacionAcademicaDTOList(List<AsignacionAcademica> asignacionAcademicaList);

    public AsignacionAcademica mapToAsignacionAcademica(AsignacionAcademicaDTO asignacionAcademicaDTO);
    

}
