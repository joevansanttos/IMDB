package ioasys.controller.dto;

import org.springframework.data.domain.Page;

import ioasys.modelo.Usuario;

public class UsuarioDto {
	
	private String nome;
	private String email;
	
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public UsuarioDto(Usuario usuario) {		
		this.email = usuario.getEmail();
		this.nome = usuario.getNome();
	}
	public static Page<UsuarioDto> converter(Page<Usuario> usuarios) {
		return usuarios.map(UsuarioDto::new);
	}
	

}
