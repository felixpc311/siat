package com.adso.siat.mappers;

import java.util.List;

import com.adso.siat.dto.AnioLectivoDTO;
import com.adso.siat.models.AnioLectivo;

public interface IAnioLectivoMapper {

    public void updateAnioLectivo(AnioLectivo anioLectivo, AnioLectivoDTO anioLectivoDTO);

    public AnioLectivoDTO mapToAnioLectivoDTO(AnioLectivo anioLectivo);

    public List<AnioLectivoDTO> mapToAnioLectivoDTOList(List<AnioLectivo> anioLectivoList);

    public AnioLectivo mapToAnioLectivo(AnioLectivoDTO anioLectivoDTO);

}
