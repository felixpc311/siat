package com.adso.siat.service;

import java.util.List;

import com.adso.siat.dto.DocenteDTO;

public interface IDocenteService {
    public DocenteDTO saveDocente(DocenteDTO docenteDTO);
    public List<DocenteDTO> getDocentes();
    public DocenteDTO getDocenteById(Long docenteId);
    public DocenteDTO updateDocente(Long docenteId, DocenteDTO docenteDTO);
    public DocenteDTO deleteDocenteById(Long docenteId);
}
