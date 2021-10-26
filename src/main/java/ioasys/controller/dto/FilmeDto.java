package ioasys.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ioasys.modelo.Ator;
import ioasys.modelo.Filme;
import ioasys.modelo.Voto;


public class FilmeDto {
	
    private String nome;
    private String diretor; 
    private String data;
    private String genero;
    private Long mediaVotos;
    private List<NomeAtorDto> atores; 
    
	
	
	public String getDiretor() {
		return diretor;
	}


	public Long getMediaVotos() {
		return mediaVotos;
	}

	public void setMediaVotos(Long mediaVotos) {
		this.mediaVotos = mediaVotos;
	}

	public List<NomeAtorDto> getAtores() {
		return atores;
	}

	public void setAtores(List<NomeAtorDto> atores) {
		this.atores = atores;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getgenero() {
		return genero;
	}

	public void setgenero(String genero) {
		this.genero = genero;
	}
	

	public static Page<FilmeDto> converter(Page<Filme> filmes) {
		return filmes.map(FilmeDto::new);
    }
	
	public FilmeDto(Filme filme){		
		
        this.diretor = filme.getdiretor();
        this.nome = filme.getnome();
        this.data = filme.getData();
        this.genero = filme.getGenero(); 
        this.mediaVotos = filme.getMediaVotos();
        
        List<Ator> atores = filme.getAtores();
        
        this.atores = new ArrayList<>();
        this.atores.addAll(filme.getAtores().stream().map(NomeAtorDto::new).collect(Collectors.toList()));
        
	}
        /*
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String text = filme.getDataCriacao().format(formatters);
        LocalDate parsedDate = LocalDate.parse(text, formatters);        
        this.dataLancamento = parsedDate;
        */
        //this.votos = new ArrayList<>();
        //this.votos.addAll(filme.getVotos().stream().map(VotoDto::new).collect(Collectors.toList()));
	
}
	
