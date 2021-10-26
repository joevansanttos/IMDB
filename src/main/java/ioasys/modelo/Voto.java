package ioasys.modelo;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "votos")
public class Voto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer valor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Filme filme;
	
	
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	@ManyToOne
	private Usuario usuario;
	
	public Voto() {
		
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
		Voto other = (Voto) obj;
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

	public Integer getvalor() {
		return valor;
	}

	public void setvalor(Integer valor) {
		this.valor = valor;
	}

	public Filme getTopico() {
		return filme;
	}

	public void setTopico(Filme filme) {
		this.filme = filme;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Usuario getusuario() {
		return usuario;
	}

	public void setusuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	public Voto(Integer valor,  Filme filme, Optional<Usuario> optionalUsuario) {
		if (optionalUsuario.isPresent()) {
			Usuario usuario = optionalUsuario.get();
			this.usuario = usuario;
		}
		
		this.valor=valor;
		this.filme = filme;
		
	}

}
