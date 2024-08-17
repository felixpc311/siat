package com.adso.siat.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.adso.siat.dto.AnioLectivoDTO;
import com.adso.siat.models.AnioLectivo;

@Component
public class AnioLectivoMapperImpl implements IAnioLectivoMapper{

    @Override
    public void updateAnioLectivo(AnioLectivo anioLectivo, AnioLectivoDTO anioLectivoDTO) {
        if (anioLectivoDTO == null) {
            return;
        }

        anioLectivo.setAnioLectivoId(anioLectivoDTO.getAnioLectivoId());
        anioLectivo.setAnioLectivoNumero(anioLectivoDTO.getAnioLectivoNumero());

    }

    @Override
    public AnioLectivoDTO mapToAnioLectivoDTO(AnioLectivo anioLectivo) {
        if (anioLectivo == null) {
            return null;
        }

        return AnioLectivoDTO.builder()
                .anioLectivoId(anioLectivo.getAnioLectivoId())
                .anioLectivoNumero(anioLectivo.getAnioLectivoNumero())
                .build();
    }

    @Override
    public List<AnioLectivoDTO> mapToAnioLectivoDTOList(List<AnioLectivo> anioLectivoList) {
        if (anioLectivoList == null) {
            return null;
        }
            
        List<AnioLectivoDTO> list = anioLectivoList.stream()
                .map(this::mapToAnioLectivoDTO)
                .toList();
        return list;
        
    }

    @Override
    public AnioLectivo mapToAnioLectivo(AnioLectivoDTO anioLectivoDTO) {
        if (anioLectivoDTO == null) {
            return null;
        }

        return AnioLectivo.builder()
                .anioLectivoId(anioLectivoDTO.getAnioLectivoId())
                .anioLectivoNumero(anioLectivoDTO.getAnioLectivoNumero())
                .build();
    }

}
