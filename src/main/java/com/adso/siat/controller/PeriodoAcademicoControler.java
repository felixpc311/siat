package com.adso.siat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adso.siat.dto.PeriodoAcademicoDTO;
import com.adso.siat.response.ResponseHandler;
import com.adso.siat.service.PeriodoAcademicoServiceImpl;
import com.adso.siat.utils.Utilities;

@RestController
@RequestMapping("/api/v1/periodosAcademicos")
@CrossOrigin(origins = "http://localhost:4200")
public class PeriodoAcademicoControler {
    @Autowired
    private PeriodoAcademicoServiceImpl periodoAcademicoService;

    @GetMapping
    public ResponseEntity<Object> getAllPeriodosAcademicos(){
        return ResponseHandler.generateResponseSuccess(
            Utilities.MESSAGE_ALL_RECORDS, 
            HttpStatus.OK, 
            periodoAcademicoService.getPeriodosAcademicos());
    }

    @GetMapping("/{periodoAcademicoId}")
    public ResponseEntity<Object> getPeriodoAcademicoById(@PathVariable("periodoAcademicoId") Long periodoAcademicoId){
        PeriodoAcademicoDTO periodoAcademicoDTO = periodoAcademicoService.getPeriodoAcademicoById(periodoAcademicoId);
        return periodoAcademicoDTO != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_RECORD,
                HttpStatus.OK,
                periodoAcademicoDTO) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_FOUND,
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/save/periodoAcademico")
    public ResponseEntity<Object> savePeriodoAcademico(@RequestBody PeriodoAcademicoDTO periodoAcademicoDTO){
        try {
            periodoAcademicoService.savePeriodoAcademico(periodoAcademicoDTO);
            return ResponseHandler.generateResponseSuccess(
                    Utilities.MESSAGE_CREATE,
                    HttpStatus.CREATED,
                    null);
        } catch (Exception e) {
            return ResponseHandler.generateResponseError(
                    Utilities.MESSAGE_NOT_CREATE,
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/periodoAcademico/{periodoAcademicoId}")
    public ResponseEntity<Object> updatePeriodoAcademico(@PathVariable("periodoAcademicoId") Long periodoAcademicoId, @RequestBody PeriodoAcademicoDTO periodoAcademicoDTO){
        return periodoAcademicoService.updatePeriodoAcademico(periodoAcademicoId, periodoAcademicoDTO) != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_UPDATE,
                HttpStatus.OK,
                null) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_UPDATE,
                HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/periodoAcademico/{periodoAcademicoId}")
    public ResponseEntity<Object> deletePeriodoAcademico(@PathVariable("periodoAcademicoId") Long periodoAcademicoId){
        return periodoAcademicoService.deletePeriodoAcademico(periodoAcademicoId) != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_DELETE,
                HttpStatus.OK,
                null) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_DELETE,
                HttpStatus.BAD_REQUEST);
    }
}
