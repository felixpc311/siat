package com.adso.siat.models;

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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "asignaciones_academicas", uniqueConstraints = @UniqueConstraint(columnNames = {
    "anioLectivoId", "docenteId", "grupoId", "asignaturaGradoId"
}))
public class AsignacionAcademica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long asignacionAcademicaId;

    @ManyToOne
    @JoinColumn(name = "anioLectivoId", nullable = false, insertable = false, updatable = false)
    private AnioLectivo anioLectivo;

    @ManyToOne
    @JoinColumn(name = "docenteId", nullable = false, insertable = false, updatable = false)
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "grupoId", nullable = false, insertable = false, updatable = false)
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "asignaturaGradoId", nullable = false, insertable = false, updatable = false)
    private AsignaturaGrado asignaturaGrado;



}
