package br.com.apisys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class MainController {

	@RequestMapping(value="/", method= RequestMethod.GET)	
	public String index(){	
 
	    return "home";
	}
 

	@RequestMapping(value="/home", method= RequestMethod.GET)
	public String home(){
 
		return "home";
	}
	
	@RequestMapping(value="/layout", method= RequestMethod.GET)
	public String layout(){
 
		return "layout";
	}

 
}