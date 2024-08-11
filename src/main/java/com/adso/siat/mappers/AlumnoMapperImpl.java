package com.adso.siat.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.adso.siat.dto.AlumnoDTO;
import com.adso.siat.models.Alumno;

@Component
public class AlumnoMapperImpl implements IAlumnoMapper {

    @Override
    public Alumno mapToAlumno(AlumnoDTO alumnoDTO) {
        if (alumnoDTO == null) {
            return null;
        }
        return Alumno.builder()
                .alumnoId(alumnoDTO.getAlumnoId())
                .identificacion(alumnoDTO.getIdentificacion())
                .apellido1(alumnoDTO.getApellido1())
                .apellido2(alumnoDTO.getApellido2())
                .nombre1(alumnoDTO.getNombre1())
                .nombre2(alumnoDTO.getNombre2())
                .celular(alumnoDTO.getCelular())
                .build();
    }

    @Override
    public AlumnoDTO mapToAlumnoDTO(Alumno alumno) {
        if (alumno == null) {
            return null;
        }
        return AlumnoDTO.builder()
                .alumnoId(alumno.getAlumnoId())
                .identificacion(alumno.getIdentificacion())
                .nombre1(alumno.getNombre1())
                .nombre2(alumno.getNombre2())
                .apellido1(alumno.getApellido1())
                .apellido2(alumno.getApellido2())
                .celular(alumno.getCelular())
                .build();
    }

    @Override
    public List<AlumnoDTO> mapToAlumnoDTOList(List<Alumno> alumnosList) {
        if (alumnosList == null) {
            return null;
        }

        List<AlumnoDTO> list = alumnosList.stream().map(this::mapToAlumnoDTO).toList();
        return list;
    }

    @Override
    public void updateAlumno(Alumno alumno, AlumnoDTO alumnoDTO) {
        if (alumnoDTO == null) {
            return;
        }

        alumno.setAlumnoId(alumnoDTO.getAlumnoId());
        alumno.setIdentificacion(alumnoDTO.getIdentificacion());
        alumno.setApellido1(alumnoDTO.getApellido1());
        alumno.setApellido2(alumnoDTO.getApellido2());
        alumno.setNombre1(alumnoDTO.getNombre1());
        alumno.setNombre2(alumnoDTO.getNombre2());
        alumno.setCelular(alumnoDTO.getCelular());
    }

}
