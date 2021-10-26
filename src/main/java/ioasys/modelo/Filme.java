package ioasys.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "filmes")
public class Filme {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String diretor;
	private String nome;
	private String genero;
	private String data;	
	private Long mediaVotos;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name = "filmes_atores", 
				joinColumns = @JoinColumn(name = "filme_id", referencedColumnName = "id"), 
				inverseJoinColumns =    @JoinColumn(name = "ator_id",   referencedColumnName = "id"))	
	private List<Ator> atores = new ArrayList<>();
	
	@OneToMany(mappedBy = "filme")
	private List<Voto> votos = new ArrayList<>();
	
	public Filme() {
        
	}	
	
	
	
	public void setMediaVotos(Long mediaVotos) {
		this.mediaVotos = mediaVotos;
	}



	public Long getMediaVotos() {
		List<Voto> votos = this.getVotos();
		Long valorTotal = (long) 0;        
        
       if(votos.isEmpty()) {        	
       	this.mediaVotos = (long) 0;
       }else {
       	for (Voto voto : votos) {
               valorTotal = (long)voto.getvalor() + valorTotal;
           }
       	
       	Long size = (long) votos.size();
       	
       	Long valorDivisao = valorTotal/size;
       	this.mediaVotos = valorDivisao;
           
       } 
		return mediaVotos;
	}


	public Filme(String diretor, String nome, String genero) {
        this.diretor = diretor;
        this.nome = nome;
        this.genero = genero;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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


	public String getDiretor() {
		return diretor;
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


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}


	public List<Ator> getAtores() {
		return atores;
	}


	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}
	
	
	

}
