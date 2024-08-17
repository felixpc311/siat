package com.adso.siat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adso.siat.models.AsignaturaGrado;

@Repository
public interface AsignaturaGradoRepository extends JpaRepository<AsignaturaGrado, Long> {

}
