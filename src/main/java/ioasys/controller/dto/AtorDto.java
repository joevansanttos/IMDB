package ioasys.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import ioasys.modelo.Ator;

public class AtorDto {
	private String nome;
    private List<DetalheFilmeParaAtorDto> filmes;

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}		


	public List<DetalheFilmeParaAtorDto> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<DetalheFilmeParaAtorDto> filmes) {
		this.filmes = filmes;
	}

	public AtorDto(Ator ator) {
		this.nome = ator.getNome();
		this.filmes = new ArrayList<>();
        this.filmes.addAll(ator.getFilmes().stream().map(DetalheFilmeParaAtorDto::new).collect(Collectors.toList()));
	}	
	

	public static Page<AtorDto> converter(Page<Ator> atores) {
		return atores.map(AtorDto::new);
    }

	
	

}
