package com.adso.siat.mappers;

import java.util.List;

import com.adso.siat.dto.GrupoDTO;
import com.adso.siat.models.Grupo;

public interface IGrupoMapper {

    public void updateGrupo(Grupo grupo, GrupoDTO grupoDTO);

    public GrupoDTO mapToGrupoDTO(Grupo grupo);

    public List<GrupoDTO> mapToGrupoDTOList(List<Grupo> grupoList);

    public Grupo mapToGrupo(GrupoDTO grupoDTO);

}
