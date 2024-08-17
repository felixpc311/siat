package com.adso.siat.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.adso.siat.dto.GradoDTO;
import com.adso.siat.models.Grado;

@Component
public class GradoMapperImpl implements IGradoMapper {

    @Override
    public void updateGrado(Grado grado, GradoDTO gradoDTO) {
        if (gradoDTO == null) {
            return;
        }

        grado.setGradoId(gradoDTO.getGradoId());
        grado.setGrado(gradoDTO.getGrado());
        grado.setGradoCodigo(gradoDTO.getGradoCodigo());
    }

    @Override
    public GradoDTO mapToGradoDTO(Grado grado) {
        if (grado == null) {
            return null;
        }

        return GradoDTO.builder()
                .gradoId(grado.getGradoId())
                .grado(grado.getGrado())
                .gradoCodigo(grado.getGradoCodigo())
                .build();
    }

    @Override
    public List<GradoDTO> mapToGradoDTOList(List<Grado> gradoList) {
        if (gradoList == null) {
            return null;
        }
        List<GradoDTO> list = gradoList.stream().map(this::mapToGradoDTO).toList();
        return list;
    }

    @Override
    public Grado mapToGrado(GradoDTO gradoDTO) {
        if (gradoDTO == null) {
            return null;
        }

        return Grado.builder()
                .gradoId(gradoDTO.getGradoId())
                .grado(gradoDTO.getGrado())
                .gradoCodigo(gradoDTO.getGradoCodigo())
                .build();
    }

}
