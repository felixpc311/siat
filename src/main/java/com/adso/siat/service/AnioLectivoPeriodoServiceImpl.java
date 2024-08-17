package com.adso.siat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.siat.dto.AnioLectivoPeriodoDTO;
import com.adso.siat.mappers.AnioLectivoPeriodoMapperImpl;
import com.adso.siat.models.AnioLectivoPeriodo;
import com.adso.siat.repository.AnioLectivoPeriodoRepository;
@Service
public class AnioLectivoPeriodoServiceImpl implements IAnioLectivoPeriodoService {
    @Autowired
    private AnioLectivoPeriodoRepository anioLectivoPeriodoRepository;
    @Autowired
    private AnioLectivoPeriodoMapperImpl anioLectivoPeriodoMapperImpl;
    @Override
    public AnioLectivoPeriodoDTO saveAnioLectivoPeriodo(AnioLectivoPeriodoDTO anioLectivoPeriodoDTO) {
        AnioLectivoPeriodo anioLectivoPeriodo = anioLectivoPeriodoMapperImpl.mapToAnioLectivoPeriodo(anioLectivoPeriodoDTO);
        AnioLectivoPeriodo savedAnioLectivoPeriodo = anioLectivoPeriodoRepository.save(anioLectivoPeriodo);
        return anioLectivoPeriodoMapperImpl.mapToAnioLectivoPeriodoDTO(savedAnioLectivoPeriodo);
    }

    @Override
    public List<AnioLectivoPeriodoDTO> getAnioLectivoPeriodos() {
        List<AnioLectivoPeriodo> anioLectivoPeriodoList = anioLectivoPeriodoRepository.findAll();
        return anioLectivoPeriodoMapperImpl.mapToAnioLectivoPeriodoDTOList(anioLectivoPeriodoList);
    }

    @Override
    public AnioLectivoPeriodoDTO getAnioLectivoPeriodoById(Long anioLectivoPeriodoId) {
        AnioLectivoPeriodo anioLectivoPeriodo = anioLectivoPeriodoRepository.findById(anioLectivoPeriodoId).orElse(null);
        return anioLectivoPeriodoMapperImpl.mapToAnioLectivoPeriodoDTO(anioLectivoPeriodo);
    }

    @Override
    public AnioLectivoPeriodoDTO updateAnioLectivoPeriodo(Long anioLectivoPeriodoId, AnioLectivoPeriodoDTO anioLectivoPeriodoDTO) {
        AnioLectivoPeriodo anioLectivoPeriodo = anioLectivoPeriodoRepository.findById(anioLectivoPeriodoId).orElse(null);
        if (anioLectivoPeriodo != null) {
            anioLectivoPeriodoMapperImpl.updateAnioLectivoPeriodo(anioLectivoPeriodo, anioLectivoPeriodoDTO);
            AnioLectivoPeriodo updatedAnioLectivoPeriodo = anioLectivoPeriodoRepository.save(anioLectivoPeriodo);
            return anioLectivoPeriodoMapperImpl.mapToAnioLectivoPeriodoDTO(updatedAnioLectivoPeriodo);
        } else {
            return null;
        }
    }

}
