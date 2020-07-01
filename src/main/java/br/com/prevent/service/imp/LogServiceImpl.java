package br.com.prevent.service.imp;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prevent.dao.LogJpaRepository;
import br.com.prevent.entity.Log;
import br.com.prevent.exceptions.InvalidException;
import br.com.prevent.service.LogService;



@Service

public class LogServiceImpl implements LogService {

	@Autowired
	private LogJpaRepository repository;



	
	@Override
	public boolean create(Log log, String nomeArquivo) throws InvalidException {
		
		
		// ID será gerado automaticamente
		log.setId(null);
		
		// Não permitir mais de uma marca com o mesmo nome
		if(this.repository.existsByNome(nomeArquivo))
			throw new InvalidException("Log já importado");
		
		// salva
		repository.save(log);
		return true;
	}

	@Override
	public Iterable<Log> findByHoraAndIpAndData(String ip, Date data, String hora) {
	
		// TODO Auto-generated method stub
		return repository.findByHoraAndIpAndData(hora, ip, data);
	}

	
	@Override
	public boolean existsByNome(String nomeArquivo)  {
		
		
		// Não permitir mais de uma marca com o mesmo nome
		if(this.repository.existsByNome(nomeArquivo))
			return false;
		

		return true;
	}
	






}
