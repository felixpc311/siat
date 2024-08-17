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

import com.adso.siat.dto.AsignacionAcademicaDTO;
import com.adso.siat.response.ResponseHandler;
import com.adso.siat.service.AsignacionAcademicaServiceImpl;
import com.adso.siat.utils.Utilities;

@RestController
@RequestMapping("/api/v1/asignacionAcademica")
@CrossOrigin(origins = "http://localhost:4200")
public class AsignacionAcademicaController {
    @Autowired
    private AsignacionAcademicaServiceImpl asignacionAcademicaService;

    @GetMapping
    public ResponseEntity<Object> getAllAsignacionAcademicas(){
        return ResponseHandler.generateResponseSuccess(
            Utilities.MESSAGE_ALL_RECORDS, 
            HttpStatus.OK, 
            asignacionAcademicaService.getAsignacionesAcademicas());
    }

    @GetMapping("/{asignacionAcademicaId}")
    public ResponseEntity<Object> getAsignacionAcademicaById(@PathVariable("asignacionAcademicaId") Long asignacionAcademicaId){
        AsignacionAcademicaDTO asignacionAcademicaDTO = asignacionAcademicaService.getAsignacionAcademicaById(asignacionAcademicaId);
        return asignacionAcademicaDTO != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_RECORD,
                HttpStatus.OK,
                asignacionAcademicaDTO) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_FOUND,
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/save/asignacionAcademica")
    public ResponseEntity<Object> saveAsignacionAcademica(@RequestBody AsignacionAcademicaDTO asignacionAcademicaDTO){
        try {
            asignacionAcademicaService.saveAsignacionAcademica(asignacionAcademicaDTO);
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

    @PutMapping("/update/asignacionAcademica/{asignacionAcademicaId}")
    public ResponseEntity<Object> updateAsignacionAcademica(@PathVariable("asignacionAcademicaId") Long asignacionAcademicaId, @RequestBody AsignacionAcademicaDTO asignacionAcademicaDTO){
        return asignacionAcademicaService.updateAsignacionAcademica(asignacionAcademicaId, asignacionAcademicaDTO) != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_UPDATE,
                HttpStatus.OK,
                null) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_UPDATE,
                HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/asignacionAcademica/{asignacionAcademicaId}")
    public ResponseEntity<Object> deleteAsignacionAcademica(@PathVariable("asignacionAcademicaId") Long asignacionAcademicaId){
        return asignacionAcademicaService.deleteAsignacionAcademicaById(asignacionAcademicaId) != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_DELETE,
                HttpStatus.OK,
                null) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_DELETE,
                HttpStatus.BAD_REQUEST);
    }

}
