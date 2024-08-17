package com.adso.siat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adso.siat.dto.AsignaturaDTO;
import com.adso.siat.response.ResponseHandler;
import com.adso.siat.service.AsignaturaServiceImpl;
import com.adso.siat.utils.Utilities;

@RestController
@RequestMapping("/api/v1/asignaturas")
@CrossOrigin(origins = "http://localhost:4200")
public class AsignaturaController {
    @Autowired
    private AsignaturaServiceImpl asignaturaService;

    @GetMapping
    public ResponseEntity<Object> getAllAsignaturas(){
        return ResponseHandler.generateResponseSuccess(
            Utilities.MESSAGE_ALL_RECORDS, 
            HttpStatus.OK, 
            asignaturaService.getAsignaturas());
    }

    @GetMapping("/{asignaturaId}")
    public ResponseEntity<Object> getAsignaturaById(@PathVariable("asignaturaId") Long asignaturaId){
        AsignaturaDTO asignaturaDTO = asignaturaService.getAsignaturaById(asignaturaId);
        return asignaturaDTO != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_RECORD,
                HttpStatus.OK,
                asignaturaDTO) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_FOUND,
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/save/asignatura")
    public ResponseEntity<Object> saveAsignatura(@RequestBody AsignaturaDTO asignaturaDTO){
        try {
            asignaturaService.saveAsignatura(asignaturaDTO);
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

    @PutMapping("/update/asignatura/{asignaturaId}")
    public ResponseEntity<Object> updateAsignatura(@PathVariable("asignaturaId") Long asignaturaId, @RequestBody AsignaturaDTO asignaturaDTO){
        return asignaturaService.updateAsignatura(asignaturaId, asignaturaDTO) != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_UPDATE,
                HttpStatus.OK,
                null) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_UPDATE,
                HttpStatus.BAD_REQUEST);
    }



}
