package com.springboot.holamundo.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/saludo")
@Api(value="HolaMundo microservices")
public class HolaMundoController {

	private static final Log log = LogFactory.getLog(HolaMundoController.class);
	
	@GetMapping(value="/hola")
	@ApiOperation(value = "Get Hola mundo", notes = "Returns Hola mundo")
	public String holaMundo() {
		log.info("Get holaMundo");
		return "Hola mundo";
	}
	
	@PostMapping(value="/adios")
	@ApiOperation(value = "Post Adios mundo cruel", notes = "Returns Adios mundo cruel")
	public String adiosMundo() {
		log.info("Post adiosMundo");
		return "Adios mundo cruel";
	}
}
