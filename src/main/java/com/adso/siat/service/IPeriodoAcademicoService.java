package com.adso.siat.service;

import java.util.List;


import com.adso.siat.dto.PeriodoAcademicoDTO;

public interface IPeriodoAcademicoService {

    public PeriodoAcademicoDTO savePeriodoAcademico(PeriodoAcademicoDTO periodoAcademicoDTO);
    public List<PeriodoAcademicoDTO> getPeriodosAcademicos();
    public PeriodoAcademicoDTO getPeriodoAcademicoById(Long periodoAcademicoId);
    public PeriodoAcademicoDTO updatePeriodoAcademico(Long periodoAcademicoId, PeriodoAcademicoDTO periodoAcademicoDTO);
    public PeriodoAcademicoDTO deletePeriodoAcademico(Long periodoAcademicoId);
}
