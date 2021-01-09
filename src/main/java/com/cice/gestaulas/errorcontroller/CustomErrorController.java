package com.cice.gestaulas.errorcontroller;

import java.io.IOException;
import java.net.ConnectException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController {

	
	@RequestMapping("/error")
	public ModelAndView showErrorPage() {
		System.out.println("LLEGA AL MAPPING ERROR DEL ERRORCONTROLLER");
		ModelAndView mav = new ModelAndView();
		mav.addObject("titulo", "Error General");
		mav.addObject("mensaje", "Contacte con el CAU");
		mav.addObject("errorPath", getErrorPath());
		mav.setViewName("error");
		return mav;
	}
	
	/*
	 * @ExceptionHandler(ConnectException.class) public String
	 * handleIOException(IOException ex, HttpServletRequest request) {
	 * 
	 * return "error"; //return ClassUtils.getShortName(ex.getClass()); }
	 */
	
	@Override
	public String getErrorPath() {
		
		return "/error";
	}

}
