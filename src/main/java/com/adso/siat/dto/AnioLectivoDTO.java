package com.adso.siat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class AnioLectivoDTO {

    private final Long anioLectivoId;
    private final String anioLectivoNumero;

}
