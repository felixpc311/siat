package com.adso.siat.mappers;

import java.util.List;

import com.adso.siat.dto.PeriodoAcademicoDTO;
import com.adso.siat.models.PeriodoAcademico;

public interface IPeriodoAcademicoMapper {
    public PeriodoAcademicoDTO mapToPeriodoAcademicoDTO(PeriodoAcademico periodoAcademico);

    public PeriodoAcademico mapToPeriodoAcademico(PeriodoAcademicoDTO periodoAcademicoDTO);

    public List<PeriodoAcademicoDTO> mapToPeriodoAcademicoDTOList(List<PeriodoAcademico> periodoAcademicoList);

    public void updatePeriodoAcademico(PeriodoAcademico periodoAcademico, PeriodoAcademicoDTO periodoAcademicoDTO);

}
