package com.cibertec.daw1_t1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

@Entity
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "El nombre del docente es obligatorio")
    private String nombres;

    @NotBlank(message = "El apellido del docente es obligatorio")
    private String apellidos;

    @NotBlank(message = "La carrera es obligatoria")
    private String carrera;

    @NotBlank(message = "La facultad es obligatoria")
    private String facultad;

    private String especialisacion;
}
