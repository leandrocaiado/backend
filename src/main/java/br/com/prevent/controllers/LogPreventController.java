package br.com.prevent.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.prevent.bean.ResponsePadrao;
import br.com.prevent.bean.Usuario;
import br.com.prevent.entity.Log;
import br.com.prevent.service.imp.LogServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@CrossOrigin
@RestController
@RequestMapping(value = { "/api/PREVENT/log" }, produces = { "application/json" })
@Api(value = "Language API", description = "Controller responsavel pelos endpoints de Log")
@Configuration
public class LogPreventController {

	@Autowired
	private LogServiceImpl service;

	Logger log = Logger.getLogger(LogPreventController.class);

	@ApiOperation(value = "Pesquisar log por / ip data / hora")
	@GetMapping({ "/pesquisa" })
	public ResponseEntity<?> pesquisa(@RequestParam(required = false) String UNN,
			@RequestParam(required = false) String data, @RequestParam(required = false) String ip,
			@RequestParam(required = false) String hora) throws IOException {
	
		
		log.info("pesquisa ");
		log.info("data" + data);
		log.info("ip" + ip);
		log.info("hora" + hora);

		List<Log> lista = null;

		ResponsePadrao responsePadrao = new ResponsePadrao();

		try {

			Iterable<Log> logList = service.findByHoraAndIpAndData(ip, new Date(data), hora);
			lista = new ArrayList<Log>();
			logList.forEach(lista::add);

		} catch (Exception e) {
			responsePadrao.setSuccess(false);
			responsePadrao.getMensagem().add(e.getMessage());
			return (ResponseEntity<?>) ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(responsePadrao);
		}



		return (ResponseEntity<?>) ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(lista);
	}
	
	
	
	@ApiOperation(value = "uploadLog")
	public ResponseEntity<?> uploadLog(@RequestBody File fileKey)
			throws IOException {

			
		log.info("uploadLog ");
		log.info("fileKey" + fileKey.getName());
	
		
		
		ResponsePadrao responsePadrao = new ResponsePadrao();
		
		
		
		Log log = new Log();
		
	
		try {
			  File caminhoDoTexto = (File) fileKey;

		        // Indicamos o arquivo que será lido
		        FileReader lerCaminhoDoTexto = new FileReader(caminhoDoTexto);

		        // criamos o objeto BufferedReader que nós oferece o método de leitura readLine()
		        BufferedReader lerArquivo = new BufferedReader(lerCaminhoDoTexto);



			    /* Fazemos um loop linha a linha do arquivo enquanto ele seja diferente de null
			       o método readLine() devolve a linha na posição do loop para a variavel linha */
			    while (lerArquivo.ready()) {
			        String texto = lerArquivo.readLine();
			        String textoSplit [] = texto.split("|");
			        //auto incremento
			        log.setId(null);
			        log.setData(new Date(textoSplit[0].split(" ")[0]));
			        log.setHora(textoSplit[0].split(" ")[1]);
			        log.setIp(textoSplit[1]);	            
			        log.setMotivo(textoSplit[2]+"|"+textoSplit[2]);
			        //insert  
			        service.create(log, caminhoDoTexto.getName());

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