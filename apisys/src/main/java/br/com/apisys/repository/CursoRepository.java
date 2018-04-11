package br.com.apisys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apisys.model.Curso;
 
@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> { }