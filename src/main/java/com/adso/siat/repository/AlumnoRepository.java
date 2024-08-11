package com.adso.siat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adso.siat.models.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}
