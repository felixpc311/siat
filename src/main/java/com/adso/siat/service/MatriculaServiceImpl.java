package com.adso.siat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.siat.dto.MatriculaDTO;
import com.adso.siat.mappers.MatriculaMapperImpl;
import com.adso.siat.models.Matricula;
import com.adso.siat.repository.MatriculaRepository;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private MatriculaMapperImpl matriculaMapperImpl;

    @Override
    public MatriculaDTO saveMatricula(MatriculaDTO matriculaDTO) {
        Matricula matricula = matriculaMapperImpl.mapToMatricula(matriculaDTO);
        Matricula savedMatricula = matriculaRepository.save(matricula);
        return matriculaMapperImpl.mapToMatriculaDTO(savedMatricula);
    }

    @Override
    public List<MatriculaDTO> getMatriculas() {
        List<Matricula> matriculasList = matriculaRepository.findAll();
        return matriculaMapperImpl.mapToMatriculaDTOList(matriculasList);
    }

    @Override
    public MatriculaDTO getMatriculaById(Long matriculaId) {
        Matricula matricula = matriculaRepository.findById(matriculaId).orElse(null);
        return matriculaMapperImpl.mapToMatriculaDTO(matricula);
    }

    @Override
    public MatriculaDTO updateMatricula(Long matriculaId, MatriculaDTO matriculaDTO) {
        Matricula matricula = matriculaRepository.findById(matriculaId).orElse(null);
        if (matricula != null) {
            matriculaMapperImpl.updateMatricula(matricula, matriculaDTO);
            Matricula updatedMatricula = matriculaRepository.save(matricula);
            return matriculaMapperImpl.mapToMatriculaDTO(updatedMatricula);
        } else {
            return null;
        }
    }

    

}
