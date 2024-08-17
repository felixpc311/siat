package com.adso.siat.service;

import java.util.List;

import com.adso.siat.dto.AsignaturaGradoDTO;

public interface IAsignaturaGradoService {
    public AsignaturaGradoDTO saveAsignaturaGrado(AsignaturaGradoDTO asignaturaGradoDTO);
    public List<AsignaturaGradoDTO> getAsignaturaGrados();
    public AsignaturaGradoDTO getAsignaturaGradoById(Long asignaturaGradoId);
    public AsignaturaGradoDTO updateAsignaturaGrado(Long asignaturaGradoId, AsignaturaGradoDTO asignaturaGradoDTO);
}
