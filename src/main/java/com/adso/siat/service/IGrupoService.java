package com.adso.siat.service;

import java.util.List;

import com.adso.siat.dto.GrupoDTO;

public interface IGrupoService {
    public GrupoDTO saveGrupo(GrupoDTO grupoDTO);
    public List<GrupoDTO> getGrupos();
    public GrupoDTO getGrupoById(Long grupoId);
    public GrupoDTO updateGrupo(Long grupoId, GrupoDTO grupoDTO);

}
