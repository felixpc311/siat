package com.adso.siat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adso.siat.models.AnioLectivo;

@Repository
public interface AnioLectivoRepository extends JpaRepository<AnioLectivo, Long> {

}
