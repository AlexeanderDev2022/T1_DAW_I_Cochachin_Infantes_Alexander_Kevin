package com.cibertec.daw1_t1.service;

import com.cibertec.daw1_t1.model.Docente;
import com.cibertec.daw1_t1.repository.DocenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocenteService {

    private final DocenteRepository docenteRepository;

    // Listar todos los docentes
    public List<Docente> listarDocente() {
        return docenteRepository.findAll();
    }

    // Filtrar por nombre (contiene, case-insensitive)
    public List<Docente> filtrarDocente(String iniciales){
        List<Docente> lista = docenteRepository.findByApellidosStartingWithIgnoreCase(iniciales);

        if(lista.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,  "No se encontraron docentes con apellidos que empiecen con: " + iniciales);
        }

        return lista;
    }

    // Crear un docente
    public Docente crearDocente(Docente docente){
        return docenteRepository.save(docente);
    }
}