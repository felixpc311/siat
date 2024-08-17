package com.adso.siat.mappers;

import java.util.List;

import com.adso.siat.dto.MatriculaDTO;
import com.adso.siat.models.Matricula;

public class MatriculaMapperImpl implements IMatriculaMapper {

    @Override
    public void updateMatricula(Matricula matricula, MatriculaDTO matriculaDTO) {
        if (matriculaDTO == null) {
            return;
        }
        matricula.setMatriculaId(matriculaDTO.getMatriculaId());
        matricula.setAnioLectivo(matriculaDTO.getAnioLectivo());
        matricula.setAlumno(matriculaDTO.getAlumno());
        matricula.setGrupo(matriculaDTO.getGrupo());
    }

    @Override
    public MatriculaDTO mapToMatriculaDTO(Matricula matricula) {
        if (matricula == null) {
            return null;
        }
        return MatriculaDTO.builder()
                .matriculaId(matricula.getMatriculaId())
                .anioLectivo(matricula.getAnioLectivo())
                .alumno(matricula.getAlumno())
                .grupo(matricula.getGrupo())
                .build();
    }

    @Override
    public List<MatriculaDTO> mapToMatriculaDTOList(List<Matricula> matriculaList) {
        if (matriculaList == null) {
            return null;
        }
        List<MatriculaDTO> list = matriculaList.stream().map(this::mapToMatriculaDTO).toList();
        return list;
    }

    @Override
    public Matricula mapToMatricula(MatriculaDTO matriculaDTO) {
        if (matriculaDTO == null) {
            return null;
        }
        return Matricula.builder()
                .matriculaId(matriculaDTO.getMatriculaId())
                .anioLectivo(matriculaDTO.getAnioLectivo())
                .alumno(matriculaDTO.getAlumno())
                .grupo(matriculaDTO.getGrupo())
                .build();
    }

}
