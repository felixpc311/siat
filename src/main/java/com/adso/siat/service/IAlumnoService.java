package com.adso.siat.service;

import java.util.List;

import com.adso.siat.dto.AlumnoDTO;

public interface IAlumnoService {
    public AlumnoDTO saveAlumno(AlumnoDTO alumnoDTO);
    public List<AlumnoDTO> getAlumnos();
    public AlumnoDTO getAlumnoById(Long alumnoId);
    public AlumnoDTO updateAlumno(Long alumnoId, AlumnoDTO alumnoDTO);
    public AlumnoDTO deleteAlumnoById(Long alumnoId);
}
