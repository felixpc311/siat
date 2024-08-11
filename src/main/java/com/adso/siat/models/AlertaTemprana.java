package com.adso.siat.models;

import java.sql.Date;

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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "alertas_tempranas", uniqueConstraints = @UniqueConstraint(columnNames = {
    "matriculaId", "asignacionAcademicaId", "anioLectivoPeriodoId"
}))
public class AlertaTemprana {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alertaTempranaId;

    @ManyToOne
    @JoinColumn(name = "matriculaId", nullable = false, insertable = false, updatable = false)
    private Matricula matricula;

    @ManyToOne
    @JoinColumn(name = "asignacionAcademicaId", nullable = false, insertable = false, updatable = false)
    private AsignacionAcademica asignacionAcademica;

    @ManyToOne
    @JoinColumn(name = "anioLectivoPeriodoId", nullable = false, insertable = false, updatable = false)
    private AnioLectivoPeriodo anioLectivoPeriodo;

    @Column(nullable = false, length = 500)
    private String descripcionAlerta;

    @Column(columnDefinition = "DATE", nullable = false, length = 10)
    private Date fechaAlerta;

}
