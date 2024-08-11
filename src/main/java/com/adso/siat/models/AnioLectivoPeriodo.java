package com.adso.siat.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "anios_lectivos_periodos", uniqueConstraints = @UniqueConstraint(columnNames = { "anioLectivoId",
        "periodoAcademicoId" }))

public class AnioLectivoPeriodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long anioLectivoPeriodoId;

    @ManyToOne
    @JoinColumn(name = "anioLectivoId", nullable = false, insertable = false, updatable = false)
    private AnioLectivo anioLectivo;

    @ManyToOne
    @JoinColumn(name = "periodoAcademicoId", nullable = false, insertable = false, updatable = false)
    private PeriodoAcademico periodoAcademico;

    @Column(columnDefinition = "DATE", length = 10, nullable = false)
    private Date fechaInicio;

    @Column(columnDefinition = "DATE", length = 10, nullable = false)
    private Date fechaFin;

}
