package com.adso.siat.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.adso.siat.dto.PeriodoAcademicoDTO;
import com.adso.siat.models.PeriodoAcademico;

@Component
public class PeriodoAcademicoMapperImpl implements IPeriodoAcademicoMapper{

    @Override
    public PeriodoAcademicoDTO mapToPeriodoAcademicoDTO(PeriodoAcademico periodoAcademico) {
        if (periodoAcademico == null) {
            return null;
        }

        return PeriodoAcademicoDTO.builder()
                .peridoAcademicoId(periodoAcademico.getPeridoAcademicoId())
                .periodoAcademicoNumero(periodoAcademico.getPeriodoAcademicoNumero())
                .build();

    }

    @Override
    public PeriodoAcademico mapToPeriodoAcademico(PeriodoAcademicoDTO periodoAcademicoDTO) {
        if (periodoAcademicoDTO == null) {
            return null;            
        }

        return PeriodoAcademico.builder()
                .peridoAcademicoId(periodoAcademicoDTO.getPeridoAcademicoId())
                .periodoAcademicoNumero(periodoAcademicoDTO.getPeriodoAcademicoNumero())
                .build();

    }

    @Override
    public List<PeriodoAcademicoDTO> mapToPeriodoAcademicoDTOList(List<PeriodoAcademico> periodoAcademicoList) {
        if (periodoAcademicoList == null) {
            return null;
        }
        List<PeriodoAcademicoDTO> list = periodoAcademicoList.stream().map(this::mapToPeriodoAcademicoDTO).toList();
        return list;
    }

    @Override
    public void updatePeriodoAcademico(PeriodoAcademico periodoAcademico, PeriodoAcademicoDTO periodoAcademicoDTO) {
        if (periodoAcademicoDTO == null) {
            return;
        }
        periodoAcademico.setPeridoAcademicoId(periodoAcademicoDTO.getPeridoAcademicoId());
        periodoAcademico.setPeriodoAcademicoNumero(periodoAcademicoDTO.getPeriodoAcademicoNumero());
    }

}
