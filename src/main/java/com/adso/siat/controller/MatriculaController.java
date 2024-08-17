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

import com.adso.siat.dto.MatriculaDTO;
import com.adso.siat.response.ResponseHandler;
import com.adso.siat.service.MatriculaServiceImpl;
import com.adso.siat.utils.Utilities;

@RestController
@RequestMapping("/api/v1/matriculas")
@CrossOrigin(origins = "http://localhost:4200")
public class MatriculaController {
    @Autowired
    private MatriculaServiceImpl matriculaService;

    @GetMapping
    public ResponseEntity<Object> getAllMatriculas(){
        return ResponseHandler.generateResponseSuccess(
            Utilities.MESSAGE_ALL_RECORDS, 
            HttpStatus.OK, 
            matriculaService.getMatriculas());
    }

    @GetMapping("/{matriculaId}")
    public ResponseEntity<Object> getMatriculaById(@PathVariable("matriculaId") Long matriculaId){
        MatriculaDTO matriculaDTO = matriculaService.getMatriculaById(matriculaId);
        return matriculaDTO != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_RECORD,
                HttpStatus.OK,
                matriculaDTO) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_FOUND,
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/save/matricula")
    public ResponseEntity<Object> saveMatricula(@RequestBody MatriculaDTO matriculaDTO){
        try {
            matriculaService.saveMatricula(matriculaDTO);
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

    @PutMapping("/update/matricula/{matriculaId}")
    public ResponseEntity<Object> updateMatricula(@PathVariable("matriculaId") Long matriculaId, @RequestBody MatriculaDTO matriculaDTO){
        return matriculaService.updateMatricula(matriculaId, matriculaDTO) != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_UPDATE,
                HttpStatus.OK,
                null) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_UPDATE,
                HttpStatus.BAD_REQUEST);
    }


}
