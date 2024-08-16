package com.adso.siat.mappers;

import java.util.List;

import com.adso.siat.dto.AlertaTempranaDTO;
import com.adso.siat.models.AlertaTemprana;

public interface IAlertaTempranaMapper {

    public AlertaTempranaDTO mapToAlertaTempranaDTO(AlertaTemprana alertaTemprana);

    public AlertaTemprana mapToAlertaTemprana(AlertaTempranaDTO alertaTempranaDTO);

    public void updateAlertaTemprana(AlertaTemprana alertaTemprana, AlertaTempranaDTO alertaTempranaDTO);

    public List<AlertaTempranaDTO> mapToAlertaTempranaDTOList(List<AlertaTemprana> alertaTempranaList);

    

}
