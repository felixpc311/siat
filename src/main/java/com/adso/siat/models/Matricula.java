package com.adso.siat.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "matriculas", uniqueConstraints = @UniqueConstraint(columnNames = {
    "anioLectivoId", "alumnoId", "grupoId"
}))
@Builder
public class Matricula {
    @Id
    private Long matriculaId;

    @ManyToOne
    @JoinColumn(name = "anioLectivoId", nullable = false, insertable = false, updatable = false)
    private AnioLectivo anioLectivo;

    @ManyToOne
    @JoinColumn(name = "alumnoId", nullable = false, insertable = false, updatable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "grupoId", nullable = false, insertable = false, updatable = false)
    private Grupo grupo;
}