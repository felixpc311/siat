package com.adso.siat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.siat.dto.AlertaTempranaDTO;
import com.adso.siat.mappers.AlertaTempranaMapperImpl;
import com.adso.siat.models.AlertaTemprana;
import com.adso.siat.repository.AlertaTempranaRepository;
@Service
public class AlertaTempranaServiceImpl implements IAlertaTempranaService {
    @Autowired
    private AlertaTempranaRepository alertaTempranaRepository;
    @Autowired
    private AlertaTempranaMapperImpl alertaTempranaMapperImpl;

    @Override
    public AlertaTempranaDTO saveAlertaTemprana(AlertaTempranaDTO alertaTempranaDTO) {
        AlertaTemprana alertaTemprana = alertaTempranaMapperImpl.mapToAlertaTemprana(alertaTempranaDTO);
        AlertaTemprana savedAlertaTemprana = alertaTempranaRepository.save(alertaTemprana);
        return alertaTempranaMapperImpl.mapToAlertaTempranaDTO(savedAlertaTemprana);
    }

    @Override
    public List<AlertaTempranaDTO> getAlertasTempranas() {
        List<AlertaTemprana> alertaTempranaList = alertaTempranaRepository.findAll();
        return alertaTempranaMapperImpl.mapToAlertaTempranaDTOList(alertaTempranaList);
    }

    @Override
    public AlertaTempranaDTO getAlertaTempranaById(Long alertaTempranaId) {
        AlertaTemprana alertaTemprana = alertaTempranaRepository.findById(alertaTempranaId).orElse(null);
        return alertaTempranaMapperImpl.mapToAlertaTempranaDTO(alertaTemprana);
    }

    @Override
    public AlertaTempranaDTO updateAlertaTemprana(Long alertaTempranaId, AlertaTempranaDTO alertaTempranaDTO) {
        AlertaTemprana alertaTemprana = alertaTempranaRepository.findById(alertaTempranaId).orElse(null);
        if (alertaTemprana != null) {
            alertaTempranaMapperImpl.updateAlertaTemprana(alertaTemprana, alertaTempranaDTO);
            AlertaTemprana updatedAlertaTemprana = alertaTempranaRepository.save(alertaTemprana);
            return alertaTempranaMapperImpl.mapToAlertaTempranaDTO(updatedAlertaTemprana);
        } else {
            return null;
        }
    }

    @Override
    public AlertaTempranaDTO deleteAlertaTempranaById(Long alertaTempranaId) {
        AlertaTemprana alertaTemprana = alertaTempranaRepository.findById(alertaTempranaId).orElse(null);
        if (alertaTemprana != null) {
            AlertaTempranaDTO deletedAlertaTempranaDTO = alertaTempranaMapperImpl.mapToAlertaTempranaDTO(alertaTemprana);
            alertaTempranaRepository.deleteById(alertaTempranaId);
            return deletedAlertaTempranaDTO;
        } else {
            return null;
        }
    }

}
