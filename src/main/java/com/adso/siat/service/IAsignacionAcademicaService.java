package com.adso.siat.service;

import java.util.List;

import com.adso.siat.dto.AsignacionAcademicaDTO;

public interface IAsignacionAcademicaService {
    public AsignacionAcademicaDTO saveAsignacionAcademica(AsignacionAcademicaDTO asignacionAcademicaDTO);
    public List<AsignacionAcademicaDTO> getAsignacionesAcademicas();
    public AsignacionAcademicaDTO getAsignacionAcademicaById(Long asignacionAcademicaId);
    public AsignacionAcademicaDTO updateAsignacionAcademica(Long asignacionAcademicaId, AsignacionAcademicaDTO asignacionAcademicaDTO);
}
