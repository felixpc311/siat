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

import com.adso.siat.dto.AsignaturaGradoDTO;
import com.adso.siat.response.ResponseHandler;
import com.adso.siat.service.AsignaturaGradoServiceImpl;
import com.adso.siat.utils.Utilities;

@RestController
@RequestMapping("/api/v1/asignaturagrado")
@CrossOrigin(origins = "http://localhost:4200")
public class AsignaturaGradoController {
    @Autowired
    private AsignaturaGradoServiceImpl asignaturaGradoService;

    @GetMapping
    public ResponseEntity<Object> getAllAsignaturaGrados(){
        return ResponseHandler.generateResponseSuccess(
            Utilities.MESSAGE_ALL_RECORDS, 
            HttpStatus.OK, 
            asignaturaGradoService.getAsignaturaGrados());
    }

    @GetMapping("/{asignaturaGradoId}")
    public ResponseEntity<Object> getAsignaturaGradoById(@PathVariable("asignaturaGradoId") Long asignaturaGradoId){
        AsignaturaGradoDTO asignaturaGradoDTO = asignaturaGradoService.getAsignaturaGradoById(asignaturaGradoId);
        return asignaturaGradoDTO != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_RECORD,
                HttpStatus.OK,
                asignaturaGradoDTO) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_FOUND,
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/save/asignaturaGrado")
    public ResponseEntity<Object> saveAsignaturaGrado(@RequestBody AsignaturaGradoDTO asignaturaGradoDTO){
        try {
            asignaturaGradoService.saveAsignaturaGrado(asignaturaGradoDTO);
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

    @PutMapping("/update/asignaturaGrado/{asignaturaGradoId}")
    public ResponseEntity<Object> updateAsignaturaGrado(@PathVariable("asignaturaGradoId") Long asignaturaGradoId, @RequestBody AsignaturaGradoDTO asignaturaGradoDTO){
        return asignaturaGradoService.updateAsignaturaGrado(asignaturaGradoId, asignaturaGradoDTO) != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_UPDATE,
                HttpStatus.OK,
                null) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_UPDATE,
                HttpStatus.BAD_REQUEST);
    }



}
