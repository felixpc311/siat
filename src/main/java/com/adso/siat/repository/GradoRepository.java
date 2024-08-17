package com.adso.siat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adso.siat.models.Grado;

@Repository
public interface GradoRepository extends JpaRepository<Grado, Long> {

}
