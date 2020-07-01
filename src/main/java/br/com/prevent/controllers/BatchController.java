package br.com.prevent.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import br.com.prevent.entity.Log;
import br.com.prevent.exceptions.InvalidException;
import br.com.prevent.service.imp.LogServiceImpl;

@Configuration
@EnableScheduling
@Controller
public class BatchController {

	@Autowired
	private LogServiceImpl service;
	//2h  este cache roda de 2 em 2 hora 
	@Scheduled(fixedDelay = 600 * 60  * 6)
	public void reportCacheEvict() throws InvalidException {
		System.out.println("*************************************************************************");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		

		
		FileFilter filter = new FileFilter() {
		    public boolean accept(File file) {
		        return file.getName().endsWith(".log");
		    }
		};

		File dir = new File(System.getProperty("user.home"));
		File[] files = dir.listFiles(filter);
		Log log = new Log();

		for(File item : files){
	        System.out.print(item);
	    
		
		 try {

		        File caminhoDoTexto = (File) item;

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
		        lerArquivo.close();
		        caminhoDoTexto.delete();
		    } catch (IOException e) {
		        System.out.println("Arquivo não encontrado");

		    }
			
			
			}
			

		System.out.println("*************************************************************************");
	}


}
