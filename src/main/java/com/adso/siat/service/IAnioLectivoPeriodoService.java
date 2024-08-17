package com.adso.siat.service;

import java.util.List;

import com.adso.siat.dto.AnioLectivoPeriodoDTO;

public interface IAnioLectivoPeriodoService {
    public AnioLectivoPeriodoDTO saveAnioLectivoPeriodo(AnioLectivoPeriodoDTO anioLectivoPeriodoDTO);
    public List<AnioLectivoPeriodoDTO> getAnioLectivoPeriodos();
    public AnioLectivoPeriodoDTO getAnioLectivoPeriodoById(Long anioLectivoPeriodoId);
    public AnioLectivoPeriodoDTO updateAnioLectivoPeriodo(Long anioLectivoPeriodoId, AnioLectivoPeriodoDTO anioLectivoPeriodoDTO);

}
