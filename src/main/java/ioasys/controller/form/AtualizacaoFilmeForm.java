package ioasys.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import ioasys.modelo.Filme;
import ioasys.repository.FilmeRepository;

public class AtualizacaoFilmeForm {
	
	@NotNull @NotEmpty @Length(min = 5)
    private String diretor;
	
    @NotNull @NotEmpty @Length(min = 10)
    private String nome;

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

	public Filme atualizar(Long id, FilmeRepository filmeRepository) {
		Filme filme = filmeRepository.getOne(id);
		filme.setdiretor(this.diretor);
		filme.setnome(this.nome);
		return filme;
	}
    
    

}
