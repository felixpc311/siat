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

import com.adso.siat.dto.GrupoDTO;
import com.adso.siat.response.ResponseHandler;
import com.adso.siat.service.GrupoServiceImpl;
import com.adso.siat.utils.Utilities;

@RestController
@RequestMapping("/api/v1/grupos")
@CrossOrigin(origins = "http://localhost:4200")
public class GrupoController {
    @Autowired
    private GrupoServiceImpl grupoService;

    @GetMapping
    public ResponseEntity<Object> getAllGrupos(){
        return ResponseHandler.generateResponseSuccess(
            Utilities.MESSAGE_ALL_RECORDS, 
            HttpStatus.OK, 
            grupoService.getGrupos());
    }

    @GetMapping("/{grupoId}")
    public ResponseEntity<Object> getGrupoById(@PathVariable("grupoId") Long grupoId){
        GrupoDTO grupoDTO = grupoService.getGrupoById(grupoId);
        return grupoDTO != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_RECORD,
                HttpStatus.OK,
                grupoDTO) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_FOUND,
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/save/grupo")
    public ResponseEntity<Object> saveGrupo(@RequestBody GrupoDTO grupoDTO){
        try {
            grupoService.saveGrupo(grupoDTO);
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

    @PutMapping("/update/grupo/{grupoId}")
    public ResponseEntity<Object> updateGrupo(@PathVariable("grupoId") Long grupoId, @RequestBody GrupoDTO grupoDTO){
        return grupoService.updateGrupo(grupoId, grupoDTO) != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_UPDATE,
                HttpStatus.OK,
                null) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_UPDATE,
                HttpStatus.BAD_REQUEST);
    }



}
