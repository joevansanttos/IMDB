package ioasys.controller.dto;

import org.springframework.data.domain.Page;

import ioasys.modelo.Ator;

public class NomeAtorDto {
	
	private String nome;

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}		


	public NomeAtorDto(Ator ator) {
		this.nome = ator.getNome();
	}	
	

	public static Page<NomeAtorDto> converter(Page<Ator> atores) {
		return atores.map(NomeAtorDto::new);
    }

}
