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

import com.adso.siat.dto.GradoDTO;
import com.adso.siat.response.ResponseHandler;
import com.adso.siat.service.GradoServiceImpl;
import com.adso.siat.utils.Utilities;

@RestController
@RequestMapping("/api/v1/grados")
@CrossOrigin(origins = "http://localhost:4200")
public class GradoController {
    @Autowired
    private GradoServiceImpl gradoService;

    @GetMapping
    public ResponseEntity<Object> getAllGrados(){
        return ResponseHandler.generateResponseSuccess(
            Utilities.MESSAGE_ALL_RECORDS, 
            HttpStatus.OK, 
            gradoService.getGrados());
    }

    @GetMapping("/{gradoId}")
    public ResponseEntity<Object> getGradoById(@PathVariable("gradoId") Long gradoId){
        GradoDTO gradoDTO = gradoService.getGradoById(gradoId);
        return gradoDTO != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_RECORD,
                HttpStatus.OK,
                gradoDTO) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_FOUND,
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/save/grado")
    public ResponseEntity<Object> saveGrado(@RequestBody GradoDTO gradoDTO){
        try {
            gradoService.saveGrado(gradoDTO);
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

    @PutMapping("/update/grado/{gradoId}")
    public ResponseEntity<Object> updateGrado(@PathVariable("gradoId") Long gradoId, @RequestBody GradoDTO gradoDTO){
        return gradoService.updateGrado(gradoId, gradoDTO) != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_UPDATE,
                HttpStatus.OK,
                null) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_UPDATE,
                HttpStatus.BAD_REQUEST);
    }


}
