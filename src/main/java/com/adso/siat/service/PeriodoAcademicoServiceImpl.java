package com.adso.siat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.siat.dto.PeriodoAcademicoDTO;
import com.adso.siat.mappers.PeriodoAcademicoMapperImpl;
import com.adso.siat.models.PeriodoAcademico;
import com.adso.siat.repository.PeriodoAcademicoRepository;

@Service
public class PeriodoAcademicoServiceImpl implements IPeriodoAcademicoService {

    @Autowired
    private PeriodoAcademicoRepository periodoAcademicoRepository;
    @Autowired
    private PeriodoAcademicoMapperImpl periodoAcademicoMapperImpl;

    @Override
    public PeriodoAcademicoDTO savePeriodoAcademico(PeriodoAcademicoDTO periodoAcademicoDTO) {
        PeriodoAcademico periodoAcademico = periodoAcademicoMapperImpl.mapToPeriodoAcademico(periodoAcademicoDTO);
        PeriodoAcademico savedPeriodoAcademico = periodoAcademicoRepository.save(periodoAcademico);
        return periodoAcademicoMapperImpl.mapToPeriodoAcademicoDTO(savedPeriodoAcademico);
    }

    @Override
    public List<PeriodoAcademicoDTO> getPeriodosAcademicos() {
        List<PeriodoAcademico> periodosAcademicosList = periodoAcademicoRepository.findAll();
        return periodoAcademicoMapperImpl.mapToPeriodoAcademicoDTOList(periodosAcademicosList);

    }

    @Override
    public PeriodoAcademicoDTO getPeriodoAcademicoById(Long periodAcademicoId) {
        PeriodoAcademico periodoAcademico = periodoAcademicoRepository.findById(periodAcademicoId).orElse(null);
        return periodoAcademicoMapperImpl.mapToPeriodoAcademicoDTO(periodoAcademico);
    }

    @Override
    public PeriodoAcademicoDTO updatePeriodoAcademico(Long periodAcademicoId, PeriodoAcademicoDTO periodoAcademicoDTO) {
        PeriodoAcademico periodoAcademico = periodoAcademicoRepository.findById(periodAcademicoId).orElse(null);
        if (periodoAcademico != null) {
            periodoAcademicoMapperImpl.updatePeriodoAcademico(periodoAcademico, periodoAcademicoDTO);
            PeriodoAcademico updatedPeriodoAcademico = periodoAcademicoRepository.save(periodoAcademico);
            return periodoAcademicoMapperImpl.mapToPeriodoAcademicoDTO(updatedPeriodoAcademico);
        } else {
            return null;
        }
    }

    @Override
    public PeriodoAcademicoDTO deletePeriodoAcademico(Long periodoAcademicoId) {
        PeriodoAcademico periodoAcademico = periodoAcademicoRepository.findById(periodoAcademicoId).orElse(null);
        if (periodoAcademico != null) {
            PeriodoAcademicoDTO deletedPeriodoAcademicoDTO = periodoAcademicoMapperImpl.mapToPeriodoAcademicoDTO(periodoAcademico);
            periodoAcademicoRepository.deleteById(periodoAcademicoId);
            return deletedPeriodoAcademicoDTO;
        } else {
            return null;
        }
    }

}
