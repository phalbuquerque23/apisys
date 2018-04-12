package br.com.apisys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apisys.model.Aluno;
 
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> { }