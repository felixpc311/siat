package com.adso.siat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.siat.dto.DocenteDTO;
import com.adso.siat.mappers.DocenteMapperImpl;
import com.adso.siat.models.Docente;
import com.adso.siat.repository.DocenteRepository;

@Service
public class DocenteServiceImpl implements IDocenteService{

    @Autowired
    private DocenteRepository docenteRepository;
    @Autowired
    private DocenteMapperImpl docenteMapperImpl;

    @Override
    public DocenteDTO saveDocente(DocenteDTO docenteDTO) {
        Docente docente = docenteMapperImpl.mapToDocente(docenteDTO);
        Docente savedDocente = docenteRepository.save(docente);
        return docenteMapperImpl.mapToDocenteDTO(savedDocente);
    }

    @Override
    public List<DocenteDTO> getDocentes() {
        List<Docente> docentesList = docenteRepository.findAll();
        return docenteMapperImpl.mapToDocenteDTOList(docentesList);
    }

    @Override
    public DocenteDTO getDocenteById(Long docenteId) {
        Docente docente = docenteRepository.findById(docenteId).orElse(null);
        return docenteMapperImpl.mapToDocenteDTO(docente);
    }

    @Override
    public DocenteDTO updateDocente(Long docenteId, DocenteDTO docenteDTO) {
        Docente docente = docenteRepository.findById(docenteId).orElse(null);
        if (docente != null) {
            docenteMapperImpl.updateDocente(docente, docenteDTO);
            Docente updatedDocente = docenteRepository.save(docente);
            return docenteMapperImpl.mapToDocenteDTO(updatedDocente);
        } else {
            return null;
        }
    }

    @Override
    public DocenteDTO deleteDocenteById(Long docenteId) {
        Docente docente = docenteRepository.findById(docenteId).orElse(null);
        if (docente != null) {
            DocenteDTO deletedDocenteDTO = docenteMapperImpl.mapToDocenteDTO(docente);
            docenteRepository.deleteById(docenteId);
            return deletedDocenteDTO;
        } else {
            return null;
        }
    }

}
