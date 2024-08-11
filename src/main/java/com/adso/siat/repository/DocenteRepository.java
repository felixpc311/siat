package com.adso.siat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adso.siat.models.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {

}
