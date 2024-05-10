package com.projeto.APIRestcomSpring.dto;

public record MedicoRecordDto(String nome, String crm, int telefone, int celular, String status, String cep, String logradouro, String complemento, String bairro, String uf, String especialidade) {
}
