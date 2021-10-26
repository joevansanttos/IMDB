package ioasys.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ioasys.controller.dto.AtorDto;
import ioasys.controller.form.AtorForm;
import ioasys.modelo.Ator;
import ioasys.modelo.Filme;
import ioasys.modelo.FilmeAtor;
import ioasys.repository.AtorRepository;
import ioasys.repository.FilmeAtorRepository;
import ioasys.repository.FilmeRepository;

@RestController
@RequestMapping("atores")
public class AtorController {
	
	@Autowired
	private AtorRepository atorRepository;
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	@Autowired
	private FilmeAtorRepository filmeAtorRepository;
	
	@GetMapping
	@Cacheable(value="listaDeAtores")
	public Page<AtorDto> lista(@RequestParam(required=false) String nomeFilme, @RequestParam(required=false) 
	@PageableDefault(sort="id", direction=Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		
		if(nomeFilme == null) {
			Page<Ator> atores = atorRepository.carregarAtoresComFilmes(paginacao);
			return AtorDto.converter(atores);
		}else {
			Page<Ator> atores = atorRepository.findAll(paginacao);
			return AtorDto.converter(atores);
		}
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value="listaDeAtores", allEntries=true)
	public ResponseEntity<AtorDto> cadastrar(@RequestBody @Valid AtorForm form, UriComponentsBuilder uriBuilder) {
		Ator ator = form.converter();
		Filme filme = filmeRepository.findByNome(form.getNomeFilme());
		if(filme ==  null || ator == null) {
			return ResponseEntity.notFound().build();
		}
		
		atorRepository.save(ator);
		FilmeAtor filmeAtor = new FilmeAtor(filme, ator);
		filmeAtorRepository.save(filmeAtor);
		URI uri = uriBuilder.path("/atores/{id}").buildAndExpand(ator.getId()).toUri();
		return ResponseEntity.created(uri).body(new AtorDto(ator));
		
	}

}
