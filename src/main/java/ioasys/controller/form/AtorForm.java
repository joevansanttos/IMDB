package ioasys.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;

import ioasys.modelo.Ator;
import ioasys.modelo.Filme;
import ioasys.repository.FilmeRepository;

public class AtorForm {
	
	@NotNull @NotEmpty @Length(min = 2)
	private String nome;
	
	@NotNull @NotEmpty @Length(min = 2)
	private String nomeFilme;
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}
	
	public Ator converter() {
		
		return new Ator(nome);
	}
	
	
	

}
