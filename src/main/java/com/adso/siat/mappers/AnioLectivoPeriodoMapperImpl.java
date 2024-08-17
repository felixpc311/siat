package com.adso.siat.mappers;

import java.util.List;

import com.adso.siat.dto.AnioLectivoPeriodoDTO;
import com.adso.siat.models.AnioLectivoPeriodo;

public class AnioLectivoPeriodoMapperImpl implements IAnioLectivoPeriodoMapper {

    @Override
    public void updateAnioLectivoPeriodo(AnioLectivoPeriodo anioLectivoPeriodo,
            AnioLectivoPeriodoDTO anioLectivoPeriodoDTO) {
        if (anioLectivoPeriodoDTO == null) {
            return;
        }
        anioLectivoPeriodo.setAnioLectivoPeriodoId(anioLectivoPeriodoDTO.getAnioLectivoPeriodoId());
        anioLectivoPeriodo.setAnioLectivo(anioLectivoPeriodoDTO.getAnioLectivo());
        anioLectivoPeriodo.setPeriodoAcademico(anioLectivoPeriodoDTO.getPeriodoAcademico());
        anioLectivoPeriodo.setFechaInicio(anioLectivoPeriodoDTO.getFechaInicio());
        anioLectivoPeriodo.setFechaFin(anioLectivoPeriodoDTO.getFechaFin());
    }

    @Override
    public AnioLectivoPeriodoDTO mapToAnioLectivoPeriodoDTO(AnioLectivoPeriodo anioLectivoPeriodo) {
        if (anioLectivoPeriodo == null) {
            return null;
        }
        return AnioLectivoPeriodoDTO.builder()
                .anioLectivoPeriodoId(anioLectivoPeriodo.getAnioLectivoPeriodoId())
                .anioLectivo(anioLectivoPeriodo.getAnioLectivo())
                .periodoAcademico(anioLectivoPeriodo.getPeriodoAcademico())
                .fechaInicio(anioLectivoPeriodo.getFechaInicio())
                .fechaFin(anioLectivoPeriodo.getFechaFin())
                .build();
    }

    @Override
    public List<AnioLectivoPeriodoDTO> mapToAnioLectivoPeriodoDTOList(List<AnioLectivoPeriodo> anioLectivoPeriodoList) {
        if (anioLectivoPeriodoList == null) {
            return null;
        }

        List<AnioLectivoPeriodoDTO> list = anioLectivoPeriodoList.stream()
                .map(this::mapToAnioLectivoPeriodoDTO)
                .toList();
        return list;
    }

    @Override
    public AnioLectivoPeriodo mapToAnioLectivoPeriodo(AnioLectivoPeriodoDTO anioLectivoPeriodoDTO) {
        if (anioLectivoPeriodoDTO == null) {
            return null;
        }

        return AnioLectivoPeriodo.builder()
                .anioLectivoPeriodoId(anioLectivoPeriodoDTO.getAnioLectivoPeriodoId())
                .anioLectivo(anioLectivoPeriodoDTO.getAnioLectivo())
                .periodoAcademico(anioLectivoPeriodoDTO.getPeriodoAcademico())
                .fechaInicio(anioLectivoPeriodoDTO.getFechaInicio())
                .fechaFin(anioLectivoPeriodoDTO.getFechaFin())
                .build();
    }

}
