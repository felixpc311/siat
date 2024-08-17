package com.adso.siat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.siat.dto.GradoDTO;
import com.adso.siat.mappers.GradoMapperImpl;
import com.adso.siat.models.Grado;
import com.adso.siat.repository.GradoRepository;

@Service
public class GradoServiceImpl implements IGradoService {

    @Autowired
    private GradoRepository gradoRepository;
    @Autowired
    private GradoMapperImpl gradoMapperImpl;

    @Override
    public GradoDTO saveGrado(GradoDTO gradoDTO) {
        Grado grado = gradoMapperImpl.mapToGrado(gradoDTO);
        Grado savedGrado = gradoRepository.save(grado);
        return gradoMapperImpl.mapToGradoDTO(savedGrado);
    }

    @Override
    public List<GradoDTO> getGrados() {
        List<Grado> gradosList = gradoRepository.findAll();
        return gradoMapperImpl.mapToGradoDTOList(gradosList);
    }

    @Override
    public GradoDTO getGradoById(Long gradoId) {
        Grado grado = gradoRepository.findById(gradoId).orElse(null);
        return gradoMapperImpl.mapToGradoDTO(grado);
    }

    @Override
    public GradoDTO updateGrado(Long gradoId, GradoDTO gradoDTO) {
        Grado grado = gradoRepository.findById(gradoId).orElse(null);
        if (grado != null) {
            gradoMapperImpl.updateGrado(grado, gradoDTO);
            Grado updatedGrado = gradoRepository.save(grado);
            return gradoMapperImpl.mapToGradoDTO(updatedGrado);
        } else {
            return null;
        }
    }

    

}
