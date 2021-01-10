package com.cice.gestaulas.errorcontroller;

import java.io.IOException;
import java.net.ConnectException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController {

	
	/*
	 * @RequestMapping("/error") public ModelAndView showErrorPage() {
	 * System.out.println("LLEGA AL MAPPING ERROR DEL ERRORCONTROLLER");
	 * ModelAndView mav = new ModelAndView(); mav.addObject("titulo",
	 * "Error General"); mav.addObject("mensaje", "Contacte con el CAU");
	 * mav.addObject("errorPath", getErrorPath()); mav.setViewName("error"); return
	 * mav; }
	 */
	
	@RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
		System.out.println("LLEGA AL MAPPING ERROR DEL ERRORCONTROLLER");
		//String mensaje = (String) request.getAttribute("message");
		System.out.println("MENSAJE DE ERROR CUSTOMERRORCONTROLLER: ------- ");
		
		System.out.println("MENSAJE DE ERROR CUSTOMERRORCONTROLLER: CODIGO DE ERROR------- " 
				+ request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
		
        if (HttpStatus.NOT_FOUND
                .value() == (int) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)) {
            return "/error/404";
        }
            
        return "error";
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
