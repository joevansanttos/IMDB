package ioasys.controller.form;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;

import ioasys.modelo.Filme;

public class FilmeForm {
	
	@NotNull @NotEmpty @Length(min = 2)
    private String diretor;
	
    @NotNull @NotEmpty @Length(min = 2)
    private String nome;
    
    @NotNull @NotEmpty @Length(min = 5)
    private String genero;
    
       

    
	public String getdiretor() {
		return diretor;
	}
	public void setdiretor(String diretor) {
		this.diretor = diretor;
	}
	public String getnome() {
		return nome;
	}
	public void setnome(String nome) {
		this.nome = nome;
	}

	public Filme converter() {	
		return new Filme(diretor, nome, genero);
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
    
    

}
