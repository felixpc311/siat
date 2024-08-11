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

import com.adso.siat.dto.AlumnoDTO;
import com.adso.siat.response.ResponseHandler;
import com.adso.siat.service.AlumnoServiceImpl;
import com.adso.siat.utils.Utilities;

@RestController
@RequestMapping("/api/v1/alumnos")
@CrossOrigin(origins = "http://localhost:4200")
public class AlumnoController {
    @Autowired
    private AlumnoServiceImpl alumnoService;

    @GetMapping
    public ResponseEntity<Object> getAllAlumnos(){
        return ResponseHandler.generateResponseSuccess(
            Utilities.MESSAGE_ALL_RECORDS, 
            HttpStatus.OK, 
            alumnoService.getAlumnos());
    }

    @GetMapping("/{alumnoId}")
    public ResponseEntity<Object> getAlumnoById(@PathVariable("alumnoId") Long alumnoId){
        AlumnoDTO alumnoDTO = alumnoService.getAlumnoById(alumnoId);
        return alumnoDTO != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_RECORD,
                HttpStatus.OK,
                alumnoDTO) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_FOUND,
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/save/alumno")
    public ResponseEntity<Object> saveAlumno(@RequestBody AlumnoDTO alumnoDTO){
        try {
            alumnoService.saveAlumno(alumnoDTO);
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

    @PutMapping("/update/alumno/{alumnoId}")
    public ResponseEntity<Object> updateAlumno(@PathVariable("alumnoId") Long alumnoId, @RequestBody AlumnoDTO alumnoDTO){
        return alumnoService.updateAlumno(alumnoId, alumnoDTO) != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_UPDATE,
                HttpStatus.OK,
                null) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_UPDATE,
                HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/alumno/{alumnoId}")
    public ResponseEntity<Object> deleteAlumno(@PathVariable("alumnoId") Long alumnoId){
        return alumnoService.deleteAlumnoById(alumnoId) != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_DELETE,
                HttpStatus.OK,
                null) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_DELETE,
                HttpStatus.BAD_REQUEST);
    }

}
