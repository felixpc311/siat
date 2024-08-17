package com.adso.siat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adso.siat.models.AsignacionAcademica;

@Repository
public interface AsignacionAcademicaRepository extends JpaRepository<AsignacionAcademica, Long> {

}
