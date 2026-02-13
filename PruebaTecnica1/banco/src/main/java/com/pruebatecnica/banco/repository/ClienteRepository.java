package com.pruebatecnica.banco.repository;

import com.pruebatecnica.banco.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByNumeroIdentificacion(String numeroIdentificacion);

    Optional<Cliente> findByCorreoElectronico(String correoElectronico);

    boolean existsByNumeroIdentificacion(String numeroIdentificacion);

}
