package ioasys.controller.form;

import java.security.Principal;
import java.util.Optional;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import ioasys.modelo.Filme;
import ioasys.modelo.Usuario;
import ioasys.modelo.Voto;
import ioasys.repository.FilmeRepository;
import ioasys.repository.UsuarioRepository;

public class VotoForm {
	
	@Min(0) @Max(4)
	private Integer valor;
	
	@NotNull @NotEmpty
	private String nomeFilme;
	
	

	public Integer getValor() {
		return valor;
	}



	public void setValor(Integer valor) {
		this.valor = valor;
	}



	public String getNomeFilme() {
		return nomeFilme;
	}



	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}



	public Voto converter(FilmeRepository filmeRepository, UsuarioRepository usuarioRepository, Principal principal) {
		Filme filme = filmeRepository.findByNome(nomeFilme);
		Optional<Usuario> usuario = usuarioRepository.findByEmail(principal.getName());
		return new Voto(valor, filme, usuario);	
	}

}
