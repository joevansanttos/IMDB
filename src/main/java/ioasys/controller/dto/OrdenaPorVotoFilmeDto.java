package ioasys.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import ioasys.modelo.Ator;
import ioasys.modelo.Filme;
import ioasys.modelo.Voto;

public class OrdenaPorVotoFilmeDto {
	
	private String nome; 
    private String diretor; 
    private String  data;
    private String genero;
    private String mediaVotos;
    private List<NomeAtorDto> atores;




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


	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	


	public String getMediaVotos() {
		return mediaVotos;
	}



	public void setMediaVotos(String mediaVotos) {
		this.mediaVotos = mediaVotos;
	}
	
	



	public List<NomeAtorDto> getAtores() {
		return atores;
	}



	public void setAtores(List<NomeAtorDto> atores) {
		this.atores = atores;
	}



	public OrdenaPorVotoFilmeDto(Filme filme){
		Integer valorTotal = 0;
        this.diretor = filme.getdiretor();
        this.nome = filme.getnome();
        this.data = filme.getData();
        this.genero = filme.getGenero(); 
        List<Voto> votos = filme.getVotos();
        
        if(votos.isEmpty()) {
        	this.mediaVotos = "sem votos ainda";
        	System.out.println("sem votos ainda");

        }else {
        	System.out.println("com votos");
        	for (Voto voto : votos) {
                valorTotal = voto.getvalor()+ valorTotal;
            }
        	Integer valorMedia = valorTotal/votos.size();
        	this.mediaVotos = valorMedia.toString() ;
            
        }    
        
        List<Ator> atores = filme.getAtores();
        
        System.out.println("Filme e: " + filme.getnome());
        for(Ator ator: atores) {
        	System.out.println("ator e: " + ator.getNome());
        }
        
        this.atores = new ArrayList<>();
        this.atores.addAll(filme.getAtores().stream().map(NomeAtorDto::new).collect(Collectors.toList()));
        
	}
	
	public static Page<OrdenaPorVotoFilmeDto> converter(Page<Filme> filmes) {
		return filmes.map(OrdenaPorVotoFilmeDto::new);
    }

}
