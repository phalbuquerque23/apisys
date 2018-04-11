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

import br.com.apisys.model.Post;
import br.com.apisys.service.PostService;

@Controller
public class PostController {
     
    @Autowired
    private PostService service;
     
    @GetMapping("/post")
    public ModelAndView findAll() {
         
        ModelAndView mv = new ModelAndView("/post");
        mv.addObject("posts", service.findAll());
         
        return mv;
    }
     
    @GetMapping("/add")
    public ModelAndView add(Post post) {
         
        ModelAndView mv = new ModelAndView("/postAdd");
        mv.addObject("post", post);
         
        return mv;
    }
    
    
    @GetMapping("/add2")
    public ModelAndView add2(Optional<Post> optional) {
         
        ModelAndView mv = new ModelAndView("/postAdd");
        mv.addObject("post", optional);
         
        return mv;
    }
     
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
         
        return add2(service.findOne(id));
    }
     
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
         
        service.delete(id);
         
        return findAll();
    }
 
    @PostMapping("/save")
    public ModelAndView save(@Valid Post post, BindingResult result) {
         
        if(result.hasErrors()) {
            return add(post);
        }
         
        service.save(post);
         
        return findAll();
    }
     
}