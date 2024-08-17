package com.adso.siat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adso.siat.models.AnioLectivoPeriodo;

@Repository
public interface AnioLectivoPeriodoRepository extends JpaRepository<AnioLectivoPeriodo, Long> {

}
