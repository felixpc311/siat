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

import com.adso.siat.dto.AnioLectivoPeriodoDTO;
import com.adso.siat.response.ResponseHandler;
import com.adso.siat.service.AnioLectivoPeriodoServiceImpl;
import com.adso.siat.utils.Utilities;

@RestController
@RequestMapping("/api/v1/anioLectivoPeriodo")
@CrossOrigin(origins = "http://localhost:4200")
public class AnioLectivoPeriodoController {
    @Autowired
    private AnioLectivoPeriodoServiceImpl anioLectivoPeriodoService;

    @GetMapping
    public ResponseEntity<Object> getAllAnioLectivoPeriodos(){
        return ResponseHandler.generateResponseSuccess(
            Utilities.MESSAGE_ALL_RECORDS, 
            HttpStatus.OK, 
            anioLectivoPeriodoService.getAnioLectivoPeriodos());
    }

    @GetMapping("/{anioLectivoPeriodoId}")
    public ResponseEntity<Object> getAnioLectivoPeriodoById(@PathVariable("anioLectivoPeriodoId") Long anioLectivoPeriodoId){
        AnioLectivoPeriodoDTO anioLectivoPeriodoDTO = anioLectivoPeriodoService.getAnioLectivoPeriodoById(anioLectivoPeriodoId);
        return anioLectivoPeriodoDTO != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_RECORD,
                HttpStatus.OK,
                anioLectivoPeriodoDTO) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_FOUND,
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/save/anioLectivoPeriodo")
    public ResponseEntity<Object> saveAnioLectivoPeriodo(@RequestBody AnioLectivoPeriodoDTO anioLectivoPeriodoDTO){
        try {
            anioLectivoPeriodoService.saveAnioLectivoPeriodo(anioLectivoPeriodoDTO);
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

    @PutMapping("/update/anioLectivoPeriodo/{anioLectivoPeriodoId}")
    public ResponseEntity<Object> updateAnioLectivoPeriodo(@PathVariable("anioLectivoPeriodoId") Long anioLectivoPeriodoId, @RequestBody AnioLectivoPeriodoDTO anioLectivoPeriodoDTO){
        return anioLectivoPeriodoService.updateAnioLectivoPeriodo(anioLectivoPeriodoId, anioLectivoPeriodoDTO) != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_UPDATE,
                HttpStatus.OK,
                null) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_UPDATE,
                HttpStatus.BAD_REQUEST);
    }


}
