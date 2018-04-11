package br.com.apisys.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
 
@Entity(name = "tb_aluno")
public class Aluno implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    @Id
    @SequenceGenerator(name = "tb_aluno_seq", sequenceName = "tb_aluno_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_aluno_seq")
    private Long id;
     
     
    @Column(nullable = false, length = 150)
    @NotBlank(message = "Nome é uma informação obrigatória.")
    private String nome;
   
    
    @Column(nullable = false)
    @NotBlank(message = "Numero Matricula é uma informação obrigatória.")
    private Integer numeroMatricula;
    
    @Column(nullable = false)
    @NotBlank(message = "Semestre é uma informação obrigatória.")
    private int semetre;
    
    //falta status enum
    
    //falta relacionamento com o curso  1 aluno --- tem --- 1 curso
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(Integer numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public int getSemetre() {
		return semetre;
	}

	public void setSemetre(int semetre) {
		this.semetre = semetre;
	}


    
    
}