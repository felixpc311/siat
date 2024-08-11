package com.adso.siat.mappers;

import java.util.List;

import com.adso.siat.dto.AlumnoDTO;
import com.adso.siat.models.Alumno;

public interface IAlumnoMapper {
    public Alumno mapToAlumno(AlumnoDTO alumnoDTO);

    public AlumnoDTO mapToAlumnoDTO(Alumno alumno);

    public List<AlumnoDTO> mapToAlumnoDTOList(List<Alumno> alumnosList);

    public void updateAlumno(Alumno alumno, AlumnoDTO alumnoDTO);

}
