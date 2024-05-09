package com.projeto.APIRestcomSpring.controllers;

import com.projeto.APIRestcomSpring.domain.Medico;
import com.projeto.APIRestcomSpring.dto.MedicoRecordDto;
import com.projeto.APIRestcomSpring.repositories.Repository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    Repository repository;

    @PostMapping("/medicos")
    public ResponseEntity<Medico> saveMedico(@RequestBody MedicoRecordDto medicoRecordDto) {
        var medico = new Medico();
        BeanUtils.copyProperties(medicoRecordDto, medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(medico));
    }
}
