package com.adso.siat.service;

import java.util.List;

import com.adso.siat.dto.GradoDTO;

public interface IGradoService {
    public GradoDTO saveGrado(GradoDTO gradoDTO);
    public List<GradoDTO> getGrados();
    public GradoDTO getGradoById(Long gradoId);
    public GradoDTO updateGrado(Long gradoId, GradoDTO gradoDTO);

}
