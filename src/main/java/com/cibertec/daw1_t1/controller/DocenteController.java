package com.cibertec.daw1_t1.controller;

import com.cibertec.daw1_t1.model.Docente;
import com.cibertec.daw1_t1.service.DocenteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docente")
@RequiredArgsConstructor
public class DocenteController {

 private final DocenteService docenteService;

 @GetMapping("/listar")
 public ResponseEntity<List<Docente>> listarDocente() {
  return ResponseEntity.ok(docenteService.listarDocente());
 }

 @GetMapping("/filtrar/{name}")
 public ResponseEntity<List<Docente>> filtrarDocentes(@PathVariable String name) {
  return ResponseEntity.ok(docenteService.filtrarDocente(name));
 }

 @PostMapping("/crear")
 public ResponseEntity<Docente> crearDocente(@RequestBody @Valid Docente docente) {
  return ResponseEntity.status(201).body(docenteService.crearDocente(docente));
 }
}