package com.projeto.APIRestcomSpring.repositories;

import com.projeto.APIRestcomSpring.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Repository extends JpaRepository<Medico, Long> {
}
