package com.adso.siat.service;

import java.util.List;

import com.adso.siat.dto.MatriculaDTO;

public interface IMatriculaService {
    public MatriculaDTO saveMatricula(MatriculaDTO matriculaDTO);
    public List<MatriculaDTO> getMatriculas();
    public MatriculaDTO getMatriculaById(Long matriculaId);
    public MatriculaDTO updateMatricula(Long matriculaId, MatriculaDTO matriculaDTO);

}
