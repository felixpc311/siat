package com.adso.siat.mappers;

import java.util.List;

import com.adso.siat.dto.MatriculaDTO;
import com.adso.siat.models.Matricula;

public interface IMatriculaMapper {

    public void updateMatricula(Matricula matricula, MatriculaDTO matriculaDTO);

    public MatriculaDTO mapToMatriculaDTO(Matricula matricula);

    public List<MatriculaDTO> mapToMatriculaDTOList(List<Matricula> matriculaList);

    public Matricula mapToMatricula(MatriculaDTO matriculaDTO);

}
