package br.com.prevent.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LOG")
public class Log {
	
	private static final long serialVersionUID = -7384271418733330983L;

	
	
	
	@Id
	@SequenceGenerator(sequenceName = "SQ_LOG_ID", name = "SEQ_LOG_ID", allocationSize = 1)
	@GeneratedValue(generator = "SEQ_LOG_ID", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	Long id;
	
	
	@Column(name = "HORA", nullable=false, length = 20, unique = false)
	String hora   = new String();
	@Column(name = "IP", nullable=false, length = 20, unique = false)
	String ip   = new String();
	@Column(name = "Data", nullable=false, length = 20, unique = false)
	Date data = new Date();
	@Column(name = "Motivo", nullable=false, length = 200, unique = false)
	String motivo   = new String();
	
	
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
