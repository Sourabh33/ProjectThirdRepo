package com.project.springmvc.configuration;

/* It is a replacement of web.xml 
 * A 100% code-based approach to configuration
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;



public class AppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
	        ctx.register(AppConfig.class);
	        ctx.setServletContext(container);
	 
	        ServletRegistration.Dynamic servlet = container.addServlet(
	                "dispatcher", new DispatcherServlet(ctx));
	 
	        servlet.setLoadOnStartup(1);
	        servlet.addMapping("/");
		
	}
	/* The content above resembles the content of web.xml 
	 * as we are using the front-controller DispatcherServlet, 
	 * assigning the mapping (url-pattern in xml) and 
	 * instead of providing the path to spring configuration 
	 * file(spring-servlet.xml) , 
	 * here we are registering the Configuration Class.
	 * 
	 * And This method onStartup Configure 
	 * the given ServletContext with any servlets, 
	 * filters, listeners context-params 
	 * and attributes necessary 
	 * for initializing this 
	 * web application.
	 */

}
