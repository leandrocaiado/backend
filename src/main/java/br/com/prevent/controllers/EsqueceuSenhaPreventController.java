package br.com.prevent.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.prevent.bean.ResponsePadrao;
import br.com.prevent.entity.Log;
import br.com.prevent.service.imp.LogServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@CrossOrigin
@RestController
@RequestMapping(value = { "/api/PREVENT/esqueceu" }, produces = { "application/json" })
@Api(value = "Language API", description = "Controller responsavel pelos endpoints Recuperar senha")
@Configuration
public class EsqueceuSenhaPreventController  {
	
	@Autowired
	private LogServiceImpl service;
	
	
	Logger log = Logger.getLogger(EsqueceuSenhaPreventController.class);

	@ApiOperation(value = "Pesquisar log por / ip data / hora")
	@GetMapping({ "/recuperarSenha" })
	public ResponseEntity<?> recuperarSenha(@RequestParam(required = false) String email
	)
			throws IOException {

			
		log.info("esqueceu ");
		log.info("email" + email);
		
		ResponsePadrao responsePadrao = new ResponsePadrao();
		

	
		try {

			responsePadrao.setSuccess(false);
			responsePadrao.getMensagem().add("Login ou senha inválido");
		} catch (Exception e) {
			responsePadrao.setSuccess(false);
			responsePadrao.getMensagem().add(e.getMessage());
			return (ResponseEntity<?>) ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(responsePadrao);
		}

	
		return (ResponseEntity<?>) ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(responsePadrao);
	}


}