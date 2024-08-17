package com.adso.siat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.siat.dto.AsignaturaGradoDTO;
import com.adso.siat.mappers.AsignaturaGradoMapperImpl;
import com.adso.siat.models.AsignaturaGrado;
import com.adso.siat.repository.AsignaturaGradoRepository;

@Service
public class AsignaturaGradoServiceImpl implements IAsignaturaGradoService {

    @Autowired
    private AsignaturaGradoRepository asignaturaGradoRepository;
    @Autowired
    private AsignaturaGradoMapperImpl asignaturaGradoMapperImpl;

    @Override
    public AsignaturaGradoDTO saveAsignaturaGrado(AsignaturaGradoDTO asignaturaGradoDTO) {
        AsignaturaGrado asignaturaGrado = asignaturaGradoMapperImpl.mapToAsignaturaGrado(asignaturaGradoDTO);
        AsignaturaGrado savedAsignaturaGrado = asignaturaGradoRepository.save(asignaturaGrado);
        return asignaturaGradoMapperImpl.mapToAsignaturaGradoDTO(savedAsignaturaGrado);
    }

    @Override
    public List<AsignaturaGradoDTO> getAsignaturaGrados() {
        List<AsignaturaGrado> asignaturaGradosList = asignaturaGradoRepository.findAll();
        return asignaturaGradoMapperImpl.mapToAsignaturaGradoDTOList(asignaturaGradosList);
    }

    @Override
    public AsignaturaGradoDTO getAsignaturaGradoById(Long asignaturaGradoId) {
        AsignaturaGrado asignaturaGrado = asignaturaGradoRepository.findById(asignaturaGradoId).orElse(null);
        return asignaturaGradoMapperImpl.mapToAsignaturaGradoDTO(asignaturaGrado);
    }

    @Override
    public AsignaturaGradoDTO updateAsignaturaGrado(Long asignaturaGradoId, AsignaturaGradoDTO asignaturaGradoDTO) {
        AsignaturaGrado asignaturaGrado = asignaturaGradoRepository.findById(asignaturaGradoId).orElse(null);
        if (asignaturaGrado != null) {
            asignaturaGradoMapperImpl.updateAsignaturaGrado(asignaturaGrado, asignaturaGradoDTO);
            AsignaturaGrado updatedAsignaturaGrado = asignaturaGradoRepository.save(asignaturaGrado);
            return asignaturaGradoMapperImpl.mapToAsignaturaGradoDTO(updatedAsignaturaGrado);
        } else {
            return null;
        }
    }

   

}
