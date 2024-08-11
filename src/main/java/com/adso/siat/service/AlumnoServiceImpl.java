package com.adso.siat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.siat.dto.AlumnoDTO;
import com.adso.siat.mappers.AlumnoMapperImpl;
import com.adso.siat.models.Alumno;
import com.adso.siat.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private AlumnoMapperImpl alumnoMapperImpl;

    @Override
    public AlumnoDTO saveAlumno(AlumnoDTO alumnoDTO) {
        Alumno alumno = alumnoMapperImpl.mapToAlumno(alumnoDTO);
        Alumno savedAlumno = alumnoRepository.save(alumno);
        return alumnoMapperImpl.mapToAlumnoDTO(savedAlumno);
    }

    @Override
    public List<AlumnoDTO> getAlumnos() {
        List<Alumno> alumnosList = alumnoRepository.findAll();
        return alumnoMapperImpl.mapToAlumnoDTOList(alumnosList);
    }

    @Override
    public AlumnoDTO getAlumnoById(Long alumnoId) {
        Alumno alumno = alumnoRepository.findById(alumnoId).orElse(null);
        return alumnoMapperImpl.mapToAlumnoDTO(alumno);
    }

    @Override
    public AlumnoDTO updateAlumno(Long alumnoId, AlumnoDTO alumnoDTO) {
        Alumno alumno = alumnoRepository.findById(alumnoId).orElse(null);
        if (alumno != null) {
            alumnoMapperImpl.updateAlumno(alumno, alumnoDTO);
            Alumno updatedAlumno = alumnoRepository.save(alumno);
            return alumnoMapperImpl.mapToAlumnoDTO(updatedAlumno);
        } else {
            return null;
        }
    }

    @Override
    public AlumnoDTO deleteAlumnoById(Long alumnoId) {
        Alumno alumno = alumnoRepository.findById(alumnoId).orElse(null);
        if (alumno != null) {
            AlumnoDTO deletedAlumnoDTO = alumnoMapperImpl.mapToAlumnoDTO(alumno);
            alumnoRepository.deleteById(alumnoId);
            return deletedAlumnoDTO;
        } else {
            return null;
        }
    }

}
