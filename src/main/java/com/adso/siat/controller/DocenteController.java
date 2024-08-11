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

import com.adso.siat.dto.DocenteDTO;
import com.adso.siat.response.ResponseHandler;
import com.adso.siat.service.DocenteServiceImpl;
import com.adso.siat.utils.Utilities;

@RestController
@RequestMapping("/api/v1/docentes")
@CrossOrigin(origins = "http://localhost:4200")
public class DocenteController {
    @Autowired
    private DocenteServiceImpl docenteService;

    @GetMapping
    public ResponseEntity<Object> getAllDocentes(){
        return ResponseHandler.generateResponseSuccess(
            Utilities.MESSAGE_ALL_RECORDS, 
            HttpStatus.OK, 
            docenteService.getDocentes());
    }

    @GetMapping("/{docenteId}")
    public ResponseEntity<Object> getDocenteById(@PathVariable("docenteId") Long docenteId){
        DocenteDTO docenteDTO = docenteService.getDocenteById(docenteId);
        return docenteDTO != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_RECORD,
                HttpStatus.OK,
                docenteDTO) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_FOUND,
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/save/docente")
    public ResponseEntity<Object> saveDocente(@RequestBody DocenteDTO docenteDTO){
        try {
            docenteService.saveDocente(docenteDTO);
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

    @PutMapping("/update/docente/{docenteId}")
    public ResponseEntity<Object> updateDocente(@PathVariable("docenteId") Long docenteId, @RequestBody DocenteDTO docenteDTO){
        return docenteService.updateDocente(docenteId, docenteDTO) != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_UPDATE,
                HttpStatus.OK,
                null) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_UPDATE,
                HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/docente/{docenteId}")
    public ResponseEntity<Object> deleteDocente(@PathVariable("docenteId") Long docenteId){
        return docenteService.deleteDocenteById(docenteId) != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_DELETE,
                HttpStatus.OK,
                null) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_DELETE,
                HttpStatus.BAD_REQUEST);
    }

}
