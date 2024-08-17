package com.adso.siat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.siat.dto.AsignaturaDTO;
import com.adso.siat.mappers.AsignaturaMapperImpl;
import com.adso.siat.models.Asignatura;
import com.adso.siat.repository.AsignaturaRepository;

@Service
public class AsignaturaServiceImpl implements IAsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;
    @Autowired
    private AsignaturaMapperImpl asignaturaMapperImpl;

    @Override
    public AsignaturaDTO saveAsignatura(AsignaturaDTO asignaturaDTO) {
        Asignatura asignatura = asignaturaMapperImpl.mapToAsignatura(asignaturaDTO);
        Asignatura savedAsignatura = asignaturaRepository.save(asignatura);
        return asignaturaMapperImpl.mapToAsignaturaDTO(savedAsignatura);
    }

    @Override
    public List<AsignaturaDTO> getAsignaturas() {
        List<Asignatura> asignaturasList = asignaturaRepository.findAll();
        return asignaturaMapperImpl.mapToAsignaturaDTOList(asignaturasList);
    }

    @Override
    public AsignaturaDTO getAsignaturaById(Long asignaturaId) {
        Asignatura asignatura = asignaturaRepository.findById(asignaturaId).orElse(null);
        return asignaturaMapperImpl.mapToAsignaturaDTO(asignatura);
    }

    @Override
    public AsignaturaDTO updateAsignatura(Long asignaturaId, AsignaturaDTO asignaturaDTO) {
        Asignatura asignatura = asignaturaRepository.findById(asignaturaId).orElse(null);
        if (asignatura != null) {
            asignaturaMapperImpl.updateAsignatura(asignatura, asignaturaDTO);
            Asignatura updatedAsignatura = asignaturaRepository.save(asignatura);
            return asignaturaMapperImpl.mapToAsignaturaDTO(updatedAsignatura);
        } else {
            return null;
        }
    }

    

}
