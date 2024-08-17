package com.adso.siat.service;

import java.util.List;

import com.adso.siat.dto.AnioLectivoDTO;

public interface IAnioLectivoService {
    public AnioLectivoDTO saveAnioLectivo(AnioLectivoDTO anioLectivoDTO);
    public List<AnioLectivoDTO> getAniosLectivos();
    public AnioLectivoDTO getAnioLectivoById(Long anioLectivoId);
    public AnioLectivoDTO updateAnioLectivo(Long anioLectivoId, AnioLectivoDTO anioLectivoDTO);

}
