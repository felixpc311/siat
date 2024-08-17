package com.adso.siat.mappers;

import java.util.List;

import com.adso.siat.dto.GradoDTO;
import com.adso.siat.models.Grado;

public interface IGradoMapper {

    public void updateGrado(Grado grado, GradoDTO gradoDTO);

    public GradoDTO mapToGradoDTO(Grado grado);

    public List<GradoDTO> mapToGradoDTOList(List<Grado> gradoList);

    public Grado mapToGrado(GradoDTO gradoDTO);

}
