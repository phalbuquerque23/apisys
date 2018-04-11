package br.com.apisys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apisys.model.Curso;
import br.com.apisys.repository.CursoRepository;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repository;
     
    public List<Curso> findAll() {
    	
    	System.out.println("find all de cursos");
        return repository.findAll();
    }
     
    public Optional<Curso> findOne(Long id) {
        return repository.findById(id);
    }
     
    public Curso save(Curso curso) {
        return repository.saveAndFlush(curso);
    }
     
    public void delete(Long id) {
        repository.deleteById(id);
    }

}