package br.com.prevent.controllers;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prevent.bean.ResponsePadrao;
import br.com.prevent.bean.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = { "/api/PREVENT/autentication" }, produces = { "application/json" })
@Api(value = "Language API", description = "Controller responsavel pelos endpoints Autenticar")
@Configuration

public class AutenticationPreventController  {

	Logger log = Logger.getLogger(AutenticationPreventController.class);
	
	@ApiOperation(value = "Logar")
	public ResponseEntity<?> login(@RequestBody Usuario user)
			throws IOException {

			
		log.info("login ");
		log.info("email" + user.getEmail());
		log.info("password" + user.getPassword());
		
		
		ResponsePadrao responsePadrao = new ResponsePadrao();
		
		
		
		
		
	
		try {
		if(user.getEmail().equals("123") && user.getPassword().equals("123")) {
			
		
			responsePadrao.setSuccess(true);
			responsePadrao.getMensagem().add("\"Bem vindo , Login efetuado com sucesso !");
		}else {
		
			
			responsePadrao.setSuccess(false);
			responsePadrao.getMensagem().add("Login ou senha inválido");
		}
				
		

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			responsePadrao.setSuccess(false);
			responsePadrao.getMensagem().add(e.getMessage());
			return (ResponseEntity<?>) ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(responsePadrao);
		}

		
		return (ResponseEntity<?>) ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(responsePadrao);
	}
}