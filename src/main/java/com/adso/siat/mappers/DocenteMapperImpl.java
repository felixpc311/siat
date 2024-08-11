package com.adso.siat.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.adso.siat.dto.DocenteDTO;
import com.adso.siat.models.Docente;

@Component
public class DocenteMapperImpl implements IDocenteMapper {

    @Override
    public Docente mapToDocente(DocenteDTO docenteDTO) {
        if (docenteDTO == null) {
            return null;
        }
        return Docente.builder()
                .docenteId(docenteDTO.getDocenteId())
                .identificacion(docenteDTO.getIdentificacion())
                .apellido1(docenteDTO.getApellido1())
                .apellido2(docenteDTO.getApellido2())
                .nombre1(docenteDTO.getNombre1())
                .nombre2(docenteDTO.getNombre2())
                .celular(docenteDTO.getCelular())
                .profesion(docenteDTO.getProfesion())
                .build();
    }

    @Override
    public DocenteDTO mapToDocenteDTO(Docente docente) {
        if (docente == null) {
            return null;
        }
        return DocenteDTO.builder()
                .docenteId(docente.getDocenteId())
                .identificacion(docente.getIdentificacion())
                .nombre1(docente.getNombre1())
                .nombre2(docente.getNombre2())
                .apellido1(docente.getApellido1())
                .apellido2(docente.getApellido2())
                .celular(docente.getCelular())
                .profesion(docente.getProfesion())
                .build();
        
    }

    @Override
    public List<DocenteDTO> mapToDocenteDTOList(List<Docente> docenteList) {
        if (docenteList == null) {
            return null;
        }
        return docenteList.stream().map(this::mapToDocenteDTO).toList();
    }

    @Override
    public void updateDocente(Docente docente, DocenteDTO docenteDTO) {
        if (docenteDTO == null) {
            return;
        }

        docente.setDocenteId(docenteDTO.getDocenteId());
        docente.setIdentificacion(docenteDTO.getIdentificacion());
        docente.setApellido1(docenteDTO.getApellido1());
        docente.setApellido2(docenteDTO.getApellido2());
        docente.setNombre1(docenteDTO.getNombre1());
        docente.setNombre2(docenteDTO.getNombre2());
        docente.setCelular(docenteDTO.getCelular());
        docente.setProfesion(docenteDTO.getProfesion());
    }

}
