package com.pruebatecnica.banco.service;

import com.pruebatecnica.banco.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente crearCliente(Cliente cliente);

    Cliente actualizarCliente(Long id, Cliente cliente);

    void eliminarCliente(Long id);

    Optional<Cliente> obtenerPorId(Long id);

    List<Cliente> obtenerTodos();
}
