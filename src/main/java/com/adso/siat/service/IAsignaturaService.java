package com.adso.siat.service;

import java.util.List;

import com.adso.siat.dto.AsignaturaDTO;

public interface IAsignaturaService {
    public AsignaturaDTO saveAsignatura(AsignaturaDTO asignaturaDTO);
    public List<AsignaturaDTO> getAsignaturas();
    public AsignaturaDTO getAsignaturaById(Long asignaturaId);
    public AsignaturaDTO updateAsignatura(Long asignaturaId, AsignaturaDTO asignaturaDTO);

}
