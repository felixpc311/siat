package com.adso.siat.service;

import java.util.List;

import com.adso.siat.dto.AlertaTempranaDTO;

public interface IAlertaTempranaService {
    public AlertaTempranaDTO saveAlertaTemprana(AlertaTempranaDTO alertaTempranaDTO);
    public List<AlertaTempranaDTO> getAlertasTempranas();
    public AlertaTempranaDTO getAlertaTempranaById(Long alertaTempranaId);
    public AlertaTempranaDTO updateAlertaTemprana(Long alertaTempranaId, AlertaTempranaDTO alertaTempranaDTO);
}
