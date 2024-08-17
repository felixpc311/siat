package com.adso.siat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adso.siat.models.AlertaTemprana;

@Repository
public interface AlertaTempranaRepository extends JpaRepository<AlertaTemprana, Long> {

}
