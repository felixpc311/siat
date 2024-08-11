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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "asignaturas_grados", uniqueConstraints = @UniqueConstraint(columnNames = { "asignaturaId", "gradoId" }))
@Builder
public class AsignaturaGrado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long asignaturaGradoId;

    @ManyToOne
    @JoinColumn(name = "asignaturaId", nullable = false, insertable = false, updatable = false)
    private Asignatura asignatura;

    @ManyToOne
    @JoinColumn(name = "gradoId", nullable = false, insertable = false, updatable = false)
    private Grado grado;
}
