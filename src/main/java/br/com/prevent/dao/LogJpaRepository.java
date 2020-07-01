package br.com.prevent.dao;



import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prevent.entity.Log;




public interface LogJpaRepository extends JpaRepository<Log, Long> {
	
	boolean existsByNome(String nome);
	Iterable<Log>  findByHoraAndIpAndData(String hora,String ip,Date data);
	
}
