package ioasys.controller;

import java.net.URI;
import java.security.Principal;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ioasys.controller.dto.VotoDto;
import ioasys.controller.form.VotoForm;
import ioasys.modelo.Voto;
import ioasys.repository.FilmeRepository;
import ioasys.repository.UsuarioRepository;
import ioasys.repository.VotoRepository;

@RestController
@RequestMapping("voto")
public class VotoController {
	
	@Autowired
	private VotoRepository votoRepository;
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	@Transactional
	@CacheEvict(value="listaDeVotos", allEntries=true)
	public ResponseEntity<VotoDto> cadastrar(@RequestBody @Valid VotoForm form, UriComponentsBuilder uriBuilder, Principal principal) {
		Voto voto = form.converter(filmeRepository, usuarioRepository, principal);
		votoRepository.save(voto);
		URI uri = uriBuilder.path("/voto/{id}").buildAndExpand(voto.getId()).toUri();
		return ResponseEntity.created(uri).body(new VotoDto(voto));
		
	}

}
