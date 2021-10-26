package ioasys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ioasys.controller.dto.UsuarioDto;
import ioasys.modelo.Usuario;
import ioasys.repository.UsuarioRepository;

@RestController
@RequestMapping ("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	@Cacheable(value="listaDeUsuarios")
	public Page<UsuarioDto> lista(@PageableDefault(sort="id", direction=Direction.DESC, page = 0, size = 10) Pageable paginacao){
		Page<Usuario> usuarios = usuarioRepository.listaUsuariosComuns(paginacao);
		return UsuarioDto.converter(usuarios);
	}

}
