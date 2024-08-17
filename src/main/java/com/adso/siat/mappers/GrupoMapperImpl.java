package com.adso.siat.mappers;

import java.util.List;

import com.adso.siat.dto.GrupoDTO;
import com.adso.siat.models.Grupo;

public class GrupoMapperImpl implements IGrupoMapper {

    @Override
    public void updateGrupo(Grupo grupo, GrupoDTO grupoDTO) {
        if (grupoDTO == null) {
            return;
        }
        grupo.setGrupoId(grupoDTO.getGrupoId());
        grupo.setGrado(grupoDTO.getGrado());
        grupo.setGrupoCodigo(grupoDTO.getGrupoCodigo());
    }

    @Override
    public GrupoDTO mapToGrupoDTO(Grupo grupo) {
        if (grupo == null) {
            return null;
        }
        return GrupoDTO.builder()
                .grupoId(grupo.getGrupoId())
                .grado(grupo.getGrado())
                .grupoCodigo(grupo.getGrupoCodigo())
                .build();
    }

    @Override
    public List<GrupoDTO> mapToGrupoDTOList(List<Grupo> grupoList) {
        if (grupoList == null) {
            return null;
        }
        List<GrupoDTO> list = grupoList.stream().map(this::mapToGrupoDTO).toList();
        return list;
    }

    @Override
    public Grupo mapToGrupo(GrupoDTO grupoDTO) {
        if (grupoDTO == null) {
            return null;
        }

        return Grupo.builder()
                .grupoId(grupoDTO.getGrupoId())
                .grado(grupoDTO.getGrado())
                .grupoCodigo(grupoDTO.getGrupoCodigo())
                .build();
    }

}
