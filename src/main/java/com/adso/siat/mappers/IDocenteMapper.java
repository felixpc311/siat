package com.adso.siat.mappers;

import java.util.List;

import com.adso.siat.dto.DocenteDTO;
import com.adso.siat.models.Docente;

public interface IDocenteMapper {
    public Docente mapToDocente(DocenteDTO docenteDTO);

    public DocenteDTO mapToDocenteDTO(Docente docente);

    public List<DocenteDTO> mapToDocenteDTOList(List<Docente> docenteList);

    public void updateDocente(Docente docente, DocenteDTO docenteDTO);
}
