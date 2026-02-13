package com.pruebatecnica.banco.service;

import com.pruebatecnica.banco.entity.Cliente;
import com.pruebatecnica.banco.repository.ClienteRepository;
import com.pruebatecnica.banco.service.impl.ClienteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void debeLanzarExcepcionSiEsMenorDeEdad() {

        Cliente cliente = Cliente.builder()
                .nombres("Juan")
                .apellidos("Perez")
                .numeroIdentificacion("123")
                .correoElectronico("juan@test.com")
                .fechaNacimiento(LocalDate.now().minusYears(10))
                .build();

        assertThrows(RuntimeException.class, () -> {
            clienteService.crearCliente(cliente);
        });
    }
}
