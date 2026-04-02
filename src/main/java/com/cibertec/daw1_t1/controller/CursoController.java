
package com.cibertec.daw1_t1.controller;

import com.cibertec.daw1_t1.model.Curso;
import com.cibertec.daw1_t1.service.CursoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Curso>> listarCursos() {
        return ResponseEntity.ok(cursoService.listarCursos());
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody @Valid Curso curso){
        return ResponseEntity.ok(cursoService.updateCurso(id, curso));

    }
}