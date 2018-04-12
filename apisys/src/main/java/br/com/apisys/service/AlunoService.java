package br.com.apisys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apisys.model.Aluno;
import br.com.apisys.repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;
     
    public List<Aluno> findAll() {
    	
        return repository.findAll();
    }
     
    public Optional<Aluno> findOne(Long id) {
        return repository.findById(id);
    }
     
    public Aluno save(Aluno aluno) {
        return repository.saveAndFlush(aluno);
    }
     
    public void delete(Long id) {
        repository.deleteById(id);
    }

}