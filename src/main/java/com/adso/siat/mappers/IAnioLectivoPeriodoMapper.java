package com.adso.siat.mappers;

import java.util.List;

import com.adso.siat.dto.AnioLectivoPeriodoDTO;
import com.adso.siat.models.AnioLectivoPeriodo;

public interface IAnioLectivoPeriodoMapper {

    public void updateAnioLectivoPeriodo(AnioLectivoPeriodo anioLectivoPeriodo, AnioLectivoPeriodoDTO anioLectivoPeriodoDTO);

    public AnioLectivoPeriodoDTO mapToAnioLectivoPeriodoDTO(AnioLectivoPeriodo anioLectivoPeriodo);

    public List<AnioLectivoPeriodoDTO> mapToAnioLectivoPeriodoDTOList(List<AnioLectivoPeriodo> anioLectivoPeriodoList);

    public AnioLectivoPeriodo mapToAnioLectivoPeriodo(AnioLectivoPeriodoDTO anioLectivoPeriodoDTO);
}
