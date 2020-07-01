package br.com.prevent.bean;

import java.util.ArrayList;
import java.util.List;

public class ResponsePadrao {
	boolean  success;
	List<String>  mensagem = new ArrayList<>();
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<String> getMensagem() {
		return mensagem;
	}
	public void setMensagem(List<String> mensagem) {
		this.mensagem = mensagem;
	}

	
}
