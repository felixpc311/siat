package com.adso.siat.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "alumnos")
public class Alumno{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alumnoId;

    @Column(unique = true, nullable = false)
    private String identificacion;

    @Column(nullable = false)
    private String apellido1;

    private String apellido2;

    @Column(nullable = false)
    private String nombre1;

    private String nombre2;


    @Column(nullable = false)
    private String celular;


    
}
