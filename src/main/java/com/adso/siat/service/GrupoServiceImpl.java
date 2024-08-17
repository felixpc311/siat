package com.adso.siat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.siat.dto.GrupoDTO;
import com.adso.siat.mappers.GrupoMapperImpl;
import com.adso.siat.models.Grupo;
import com.adso.siat.repository.GrupoRepository;

@Service
public class GrupoServiceImpl implements IGrupoService {

    @Autowired
    private GrupoRepository grupoRepository;
    @Autowired
    private GrupoMapperImpl grupoMapperImpl;

    @Override
    public GrupoDTO saveGrupo(GrupoDTO grupoDTO) {
        Grupo grupo = grupoMapperImpl.mapToGrupo(grupoDTO);
        Grupo savedGrupo = grupoRepository.save(grupo);
        return grupoMapperImpl.mapToGrupoDTO(savedGrupo);
    }

    @Override
    public List<GrupoDTO> getGrupos() {
        List<Grupo> gruposList = grupoRepository.findAll();
        return grupoMapperImpl.mapToGrupoDTOList(gruposList);
    }

    @Override
    public GrupoDTO getGrupoById(Long grupoId) {
        Grupo grupo = grupoRepository.findById(grupoId).orElse(null);
        return grupoMapperImpl.mapToGrupoDTO(grupo);
    }

    @Override
    public GrupoDTO updateGrupo(Long grupoId, GrupoDTO grupoDTO) {
        Grupo grupo = grupoRepository.findById(grupoId).orElse(null);
        if (grupo != null) {
            grupoMapperImpl.updateGrupo(grupo, grupoDTO);
            Grupo updatedGrupo = grupoRepository.save(grupo);
            return grupoMapperImpl.mapToGrupoDTO(updatedGrupo);
        } else {
            return null;
        }
    }

    

}
