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

import com.adso.siat.dto.AnioLectivoDTO;
import com.adso.siat.response.ResponseHandler;
import com.adso.siat.service.AnioLectivoServiceImpl;
import com.adso.siat.utils.Utilities;

@RestController
@RequestMapping("/api/v1/anioLectivo")
@CrossOrigin(origins = "http://localhost:4200")
public class AnioLectivoController {
    @Autowired
    private AnioLectivoServiceImpl anioLectivoService;

    @GetMapping
    public ResponseEntity<Object> getAllAnioLectivos(){
        return ResponseHandler.generateResponseSuccess(
            Utilities.MESSAGE_ALL_RECORDS, 
            HttpStatus.OK, 
            anioLectivoService.getAniosLectivos());
    }

    @GetMapping("/{anioLectivoId}")
    public ResponseEntity<Object> getAnioLectivoById(@PathVariable("anioLectivoId") Long anioLectivoId){
        AnioLectivoDTO anioLectivoDTO = anioLectivoService.getAnioLectivoById(anioLectivoId);
        return anioLectivoDTO != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_RECORD,
                HttpStatus.OK,
                anioLectivoDTO) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_FOUND,
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/save/anioLectivo")
    public ResponseEntity<Object> saveAnioLectivo(@RequestBody AnioLectivoDTO anioLectivoDTO){
        try {
            anioLectivoService.saveAnioLectivo(anioLectivoDTO);
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

    @PutMapping("/update/anioLectivo/{anioLectivoId}")
    public ResponseEntity<Object> updateAnioLectivo(@PathVariable("anioLectivoId") Long anioLectivoId, @RequestBody AnioLectivoDTO anioLectivoDTO){
        return anioLectivoService.updateAnioLectivo(anioLectivoId, anioLectivoDTO) != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_UPDATE,
                HttpStatus.OK,
                null) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_UPDATE,
                HttpStatus.BAD_REQUEST);
    }
}
