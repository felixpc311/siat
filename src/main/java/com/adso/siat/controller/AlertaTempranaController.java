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

import com.adso.siat.dto.AlertaTempranaDTO;
import com.adso.siat.response.ResponseHandler;
import com.adso.siat.service.AlertaTempranaServiceImpl;
import com.adso.siat.utils.Utilities;

@RestController
@RequestMapping("/api/v1/alertatemprana")
@CrossOrigin(origins = "http://localhost:4200")
public class AlertaTempranaController {
    @Autowired
    private AlertaTempranaServiceImpl alertaTempranaService;

    @GetMapping
    public ResponseEntity<Object> getAllAlertaTempranas(){
        return ResponseHandler.generateResponseSuccess(
            Utilities.MESSAGE_ALL_RECORDS, 
            HttpStatus.OK, 
            alertaTempranaService.getAlertasTempranas());
    }

    @GetMapping("/{alertaTempranaId}")
    public ResponseEntity<Object> getAlertaTempranaById(@PathVariable("alertaTempranaId") Long alertaTempranaId){
        AlertaTempranaDTO alertaTempranaDTO = alertaTempranaService.getAlertaTempranaById(alertaTempranaId);
        return alertaTempranaDTO != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_RECORD,
                HttpStatus.OK,
                alertaTempranaDTO) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_FOUND,
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/save/alertaTemprana")
    public ResponseEntity<Object> saveAlertaTemprana(@RequestBody AlertaTempranaDTO alertaTempranaDTO){
        try {
            alertaTempranaService.saveAlertaTemprana(alertaTempranaDTO);
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

    @PutMapping("/update/alertaTemprana/{alertaTempranaId}")
    public ResponseEntity<Object> updateAlertaTemprana(@PathVariable("alertaTempranaId") Long alertaTempranaId, @RequestBody AlertaTempranaDTO alertaTempranaDTO){
        return alertaTempranaService.updateAlertaTemprana(alertaTempranaId, alertaTempranaDTO) != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_UPDATE,
                HttpStatus.OK,
                null) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_UPDATE,
                HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/alertaTemprana/{alertaTempranaId}")
    public ResponseEntity<Object> deleteAlertaTemprana(@PathVariable("alertaTempranaId") Long alertaTempranaId){
        return alertaTempranaService.deleteAlertaTempranaById(alertaTempranaId) != null ?
            ResponseHandler.generateResponseSuccess(
                Utilities.MESSAGE_DELETE,
                HttpStatus.OK,
                null) :
            ResponseHandler.generateResponseError(
                Utilities.MESSAGE_NOT_DELETE,
                HttpStatus.BAD_REQUEST);
    }

}
