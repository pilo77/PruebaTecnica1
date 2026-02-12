package com.pruebatecnica.banco.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;


@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El tipo de identificación es obligatorio")
    @Column(nullable = false)
    private String tipoIdentificacion;

    @NotBlank(message = "El número de identificación es obligatorio")
    @Column(nullable = false, unique = true)
    private String numeroIdentificacion;


    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, message = "El nombre debe tener mínimo 2 caracteres")
    @Column(nullable = false, length = 100)
    private String nombres;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 2, message = "El apellido debe tener mínimo 2 caracteres")
    @Column(nullable = false, length = 100)
    private String apellidos;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Debe tener formato válido de correo")
    @Column(nullable = false, unique = true)
    private String correoElectronico;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaModificacion;

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.fechaModificacion = LocalDateTime.now();
    }
    public boolean esMayorDeEdad() {
        if (fechaNacimiento == null) return false;
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }


}
