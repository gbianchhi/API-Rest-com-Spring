package com.projeto.APIRestcomSpring.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_MEDICOS")
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String CRM;
    private int telefone;
    private int celular;
    private String status;
    private String CEP;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String UF;
    private String especialidade;



}
