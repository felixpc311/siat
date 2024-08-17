package com.adso.siat.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.adso.siat.dto.AlertaTempranaDTO;
import com.adso.siat.models.AlertaTemprana;

@Component
public class AlertaTempranaMapperImpl implements IAlertaTempranaMapper {

    @Override
    public AlertaTempranaDTO mapToAlertaTempranaDTO(AlertaTemprana alertaTemprana) {
        if (alertaTemprana == null) {
            return null;
        }

        return AlertaTempranaDTO.builder()
                .alertaTempranaId(alertaTemprana.getAlertaTempranaId())
                .matricula(alertaTemprana.getMatricula())
                .asignacionAcademica(alertaTemprana.getAsignacionAcademica())
                .anioLectivoPeriodo(alertaTemprana.getAnioLectivoPeriodo())
                .descripcionAlerta(alertaTemprana.getDescripcionAlerta())
                .fechaAlerta(alertaTemprana.getFechaAlerta())
                .build();
        
    }

    @Override
    public AlertaTemprana mapToAlertaTemprana(AlertaTempranaDTO alertaTempranaDTO) {
        if (alertaTempranaDTO == null) {
            return null;
        }

        return AlertaTemprana.builder()
                .alertaTempranaId(alertaTempranaDTO.getAlertaTempranaId())
                .matricula(alertaTempranaDTO.getMatricula())
                .asignacionAcademica(alertaTempranaDTO.getAsignacionAcademica())
                .anioLectivoPeriodo(alertaTempranaDTO.getAnioLectivoPeriodo())
                .descripcionAlerta(alertaTempranaDTO.getDescripcionAlerta())
                .fechaAlerta(alertaTempranaDTO.getFechaAlerta())
                .build();
    }

    @Override
    public void updateAlertaTemprana(AlertaTemprana alertaTemprana, AlertaTempranaDTO alertaTempranaDTO) {
        if (alertaTempranaDTO == null) {
            return;
        }

        alertaTemprana.setAlertaTempranaId(alertaTempranaDTO.getAlertaTempranaId());
        alertaTemprana.setMatricula(alertaTempranaDTO.getMatricula());
        alertaTemprana.setAsignacionAcademica(alertaTempranaDTO.getAsignacionAcademica());
        alertaTemprana.setAnioLectivoPeriodo(alertaTempranaDTO.getAnioLectivoPeriodo());
        alertaTemprana.setDescripcionAlerta(alertaTempranaDTO.getDescripcionAlerta());
        alertaTemprana.setFechaAlerta(alertaTempranaDTO.getFechaAlerta());
    }

    @Override
    public List<AlertaTempranaDTO> mapToAlertaTempranaDTOList(List<AlertaTemprana> alertaTempranaList) {
        if (alertaTempranaList == null) {
            return null;
        }

        List<AlertaTempranaDTO> list = alertaTempranaList.stream().map(this::mapToAlertaTempranaDTO).toList();
        return list;
    }



}
