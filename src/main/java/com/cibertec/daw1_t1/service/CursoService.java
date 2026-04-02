package com.cibertec.daw1_t1.service;

import com.cibertec.daw1_t1.model.Curso;
import com.cibertec.daw1_t1.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;

    // Listar todos los cursos
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    // Actualizar curso
    public Curso updateCurso(Long id, Curso cursoActualizado) {
        Curso cursoExistente = cursoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "No se puede actualizar porque no existe curso con ID: " + id
                ));

        // Actualizar campos
        cursoExistente.setNombre(cursoActualizado.getNombre());
        cursoExistente.setCarrera(cursoActualizado.getCarrera());
        cursoExistente.setEspecificacion(cursoActualizado.getEspecificacion());

        // Guardar cambios y retornar
        return cursoRepository.save(cursoExistente);
    }
}