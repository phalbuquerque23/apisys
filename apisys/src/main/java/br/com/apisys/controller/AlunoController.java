package br.com.apisys.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.apisys.enums.StatusCurso;
import br.com.apisys.model.Aluno;
import br.com.apisys.service.AlunoService;
import br.com.apisys.service.CursoService;

@Controller
public class AlunoController {
     
    @Autowired
    private AlunoService service;
    
    @Autowired
    private CursoService serviceCurso;
     
    @GetMapping("/aluno")
    public ModelAndView findAll() {
         
        ModelAndView mv = new ModelAndView("/aluno");
        mv.addObject("alunos", service.findAll());   
        return mv;
    }
     
    @GetMapping("/alunoAdd")
    public ModelAndView add(Aluno aluno) {
         
        ModelAndView mv = new ModelAndView("/alunoAdd");
        mv.addObject("aluno", aluno);
        mv.addObject("cursos", serviceCurso.findAll());
        mv.addObject("statusList",StatusCurso.values());
         
        return mv;
    }
    
//    @GetMapping("/alunoAdd")
//    public ModelAndView pesquisa() {
//         
//        ModelAndView mv = new ModelAndView("/alunoAdd");
//        mv.addObject("aluno", aluno);
//        mv.addObject("cursos", serviceCurso.findAll());
//        mv.addObject("statusList",StatusCurso.values());
//         
//        return mv;
//    }
    
    
    @GetMapping("/alunoAdd2")
    public ModelAndView add2(Optional<Aluno> optional) {
         
        ModelAndView mv = new ModelAndView("/alunoAdd");
        mv.addObject("aluno", optional);
        mv.addObject("cursos", serviceCurso.findAll());
        mv.addObject("statusList",StatusCurso.values());
         
        return mv;
    }
     
    @GetMapping("/editAluno/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
         
        return add2(service.findOne(id));
    }
     
    @GetMapping("/deleteAluno/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
         
        service.delete(id);
         
        return findAll();
    }
 
    @PostMapping("/saveAluno")
    public ModelAndView save(@Valid Aluno aluno, BindingResult result) {
         
        if(result.hasErrors()) {
            return add(aluno);
        }
         
        service.save(aluno);
         
        return findAll();
    }
     
}