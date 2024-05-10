package com.projeto.APIRestcomSpring.controllers;

import com.projeto.APIRestcomSpring.domain.Medico;
import com.projeto.APIRestcomSpring.dto.MedicoRecordDto;
import com.projeto.APIRestcomSpring.repositories.Repository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/medicos")
    public ResponseEntity<List<Medico>> gettAllMedicos() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/medicos/{id}")
    public ResponseEntity<Object> getOneMedico(@PathVariable(value = "id") long id) {
        Optional<Medico> medico0 = repository.findById(id);
        if(medico0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico não encontrado.");
        } else
            return ResponseEntity.status(HttpStatus.OK).body(medico0.get());
    }

    @PutMapping("/medicos/{id}")
    public ResponseEntity<Object> updateMedico(@PathVariable(value = "id") long id, @RequestBody MedicoRecordDto medicoRecordDto) {
        Optional<Medico> medico0 = repository.findById(id);
        if(medico0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico não encontrado.");
        }
        var medico = medico0.get();
        BeanUtils.copyProperties(medicoRecordDto, medico);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(medico));
    }

    @DeleteMapping("/medicos/{id}")
    public ResponseEntity<Object> updateMedico(@PathVariable(value = "id") long id) {
        Optional<Medico> medico0 = repository.findById(id);
        if(medico0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico não encontrado.");
        }
        var medico = medico0.get();
        repository.delete(medico);
        return ResponseEntity.status(HttpStatus.OK).body("Médico deletado com sucesso.");
    }
}
