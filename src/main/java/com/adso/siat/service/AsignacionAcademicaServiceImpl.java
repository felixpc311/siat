package com.adso.siat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.siat.dto.AsignacionAcademicaDTO;
import com.adso.siat.mappers.AsignacionAcademicaMapperImpl;
import com.adso.siat.models.AsignacionAcademica;
import com.adso.siat.repository.AsignacionAcademicaRepository;

@Service
public class AsignacionAcademicaServiceImpl implements IAsignacionAcademicaService {

    @Autowired
    private AsignacionAcademicaRepository asignacionAcademicaRepository;
    @Autowired
    private AsignacionAcademicaMapperImpl asignacionAcademicaMapperImpl;

    @Override
    public AsignacionAcademicaDTO saveAsignacionAcademica(AsignacionAcademicaDTO asignacionAcademicaDTO) {
        AsignacionAcademica asignacionAcademica = asignacionAcademicaMapperImpl.mapToAsignacionAcademica(asignacionAcademicaDTO);
        AsignacionAcademica savedAsignacionAcademica = asignacionAcademicaRepository.save(asignacionAcademica);
        return asignacionAcademicaMapperImpl.mapToAsignacionAcademicaDTO(savedAsignacionAcademica);
    }

    @Override
    public List<AsignacionAcademicaDTO> getAsignacionesAcademicas() {
        List<AsignacionAcademica> asignacionAcademicasList = asignacionAcademicaRepository.findAll();
        return asignacionAcademicaMapperImpl.mapToAsignacionAcademicaDTOList(asignacionAcademicasList);
    }

    @Override
    public AsignacionAcademicaDTO getAsignacionAcademicaById(Long asignacionAcademicaId) {
        AsignacionAcademica asignacionAcademica = asignacionAcademicaRepository.findById(asignacionAcademicaId).orElse(null);
        return asignacionAcademicaMapperImpl.mapToAsignacionAcademicaDTO(asignacionAcademica);
    }

    @Override
    public AsignacionAcademicaDTO updateAsignacionAcademica(Long asignacionAcademicaId, AsignacionAcademicaDTO asignacionAcademicaDTO) {
        AsignacionAcademica asignacionAcademica = asignacionAcademicaRepository.findById(asignacionAcademicaId).orElse(null);
        if (asignacionAcademica != null) {
            asignacionAcademicaMapperImpl.updateAsignacionAcademica(asignacionAcademica, asignacionAcademicaDTO);
            AsignacionAcademica updatedAsignacionAcademica = asignacionAcademicaRepository.save(asignacionAcademica);
            return asignacionAcademicaMapperImpl.mapToAsignacionAcademicaDTO(updatedAsignacionAcademica);
        } else {
            return null;
        }
    }

    @Override
    public AsignacionAcademicaDTO deleteAsignacionAcademicaById(Long asignacionAcademicaId) {
        AsignacionAcademica asignacionAcademica = asignacionAcademicaRepository.findById(asignacionAcademicaId).orElse(null);
        if (asignacionAcademica != null) {
            AsignacionAcademicaDTO deletedAsignacionAcademicaDTO = asignacionAcademicaMapperImpl.mapToAsignacionAcademicaDTO(asignacionAcademica);
            asignacionAcademicaRepository.deleteById(asignacionAcademicaId);
            return deletedAsignacionAcademicaDTO;
        } else {
            return null;
        }
    }

}
