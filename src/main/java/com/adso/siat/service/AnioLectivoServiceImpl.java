package com.adso.siat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.siat.dto.AnioLectivoDTO;
import com.adso.siat.mappers.AnioLectivoMapperImpl;
import com.adso.siat.models.AnioLectivo;
import com.adso.siat.repository.AnioLectivoRepository;
@Service
public class AnioLectivoServiceImpl implements IAnioLectivoService {
    @Autowired
    private AnioLectivoRepository anioLectivoRepository;
    @Autowired
    private AnioLectivoMapperImpl anioLectivoMapperImpl;
    @Override
    public AnioLectivoDTO saveAnioLectivo(AnioLectivoDTO anioLectivoDTO) {
        AnioLectivo anioLectivo = anioLectivoMapperImpl.mapToAnioLectivo(anioLectivoDTO);
        AnioLectivo savedAnioLectivo = anioLectivoRepository.save(anioLectivo);
        return anioLectivoMapperImpl.mapToAnioLectivoDTO(savedAnioLectivo);
    }

    @Override
    public List<AnioLectivoDTO> getAniosLectivos() {
        List<AnioLectivo> anioLectivoList = anioLectivoRepository.findAll();
        return anioLectivoMapperImpl.mapToAnioLectivoDTOList(anioLectivoList);
    }

    @Override
    public AnioLectivoDTO getAnioLectivoById(Long anioLectivoId) {
        AnioLectivo anioLectivo = anioLectivoRepository.findById(anioLectivoId).orElse(null);
        return anioLectivoMapperImpl.mapToAnioLectivoDTO(anioLectivo);
    }

    @Override
    public AnioLectivoDTO updateAnioLectivo(Long anioLectivoId, AnioLectivoDTO anioLectivoDTO) {
        AnioLectivo anioLectivo = anioLectivoRepository.findById(anioLectivoId).orElse(null);
        if (anioLectivo != null) {
            anioLectivoMapperImpl.updateAnioLectivo(anioLectivo, anioLectivoDTO);
            AnioLectivo updatedAnioLectivo = anioLectivoRepository.save(anioLectivo);
            return anioLectivoMapperImpl.mapToAnioLectivoDTO(updatedAnioLectivo);
        } else {
            return null;
        }
    }

}
