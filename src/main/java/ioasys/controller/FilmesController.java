package ioasys.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ioasys.controller.dto.DetalhesDoFilmeDto;
import ioasys.controller.dto.FilmeDto;
import ioasys.controller.form.AtualizacaoFilmeForm;
import ioasys.controller.form.FilmeForm;
import ioasys.modelo.Filme;
import ioasys.repository.FilmeRepository;

@RestController
@RequestMapping ("/filmes")
public class FilmesController {
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	
	
	@GetMapping
	@Cacheable(value="listaDeFilmes")
	public Page<FilmeDto> lista(@RequestParam(required=false) String nomeAtor, @RequestParam(required=false) String diretor, 
			@RequestParam(required=false) String nome, @RequestParam(required=false) String genero,
			@PageableDefault(sort="mediaVotos" , direction=Direction.DESC, page = 0, size = 10)  Pageable paginacao) {
		
		Pageable paginacaoTeste = PageRequest.of(0, 10, Sort.by("mediaVotos").descending().and(Sort.by("nome")));
		
		 if (nomeAtor == null & diretor == null & nome == null & genero == null) {
             Page<Filme> filmes = filmeRepository.carregarTodosFilmes(paginacaoTeste);
             return FilmeDto.converter(filmes);
		 } else if(nomeAtor != null & diretor == null & nome == null & genero == null) {
              Page<Filme> filmes = filmeRepository.carregarPorNomeDoAtor(nomeAtor, paginacao);
              return FilmeDto.converter(filmes);
		 }else if(nomeAtor == null & diretor != null & nome == null & genero == null) {
			 Page<Filme> filmes = filmeRepository.carregarPorDiretor(diretor, paginacao);
             return FilmeDto.converter(filmes);
		 }else if(nomeAtor == null & diretor == null & nome == null & genero != null) {
			 Page<Filme> filmes = filmeRepository.carregarPorGenero(genero, paginacao);
             return FilmeDto.converter(filmes);
		 }
		 
		 
		 
		 
		 else {
			 return null;
		 }
	}	
	
	
	@PostMapping
	@Transactional
	@CacheEvict(value="listaDeFilmes", allEntries=true)
	public ResponseEntity<FilmeDto> cadastrar(@RequestBody @Valid FilmeForm form, UriComponentsBuilder uriBuilder) {
		Filme filme = form.converter();
		filmeRepository.save(filme);
		URI uri = uriBuilder.path("/filmes/{id}").buildAndExpand(filme.getId()).toUri();
		return ResponseEntity.created(uri).body(new FilmeDto(filme));
		
	}
	
	
	
	@GetMapping ("{id}")
	public ResponseEntity<DetalhesDoFilmeDto> detalhar(@PathVariable Long id) {
		Optional<Filme> filme = filmeRepository.findById(id);
		if(filme.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoFilmeDto(filme.get())) ;
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
	@PutMapping("{id}")
	@Transactional
	@CacheEvict(value="listaDeFilmes", allEntries=true)
	public ResponseEntity<FilmeDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoFilmeForm form ){
		Optional<Filme> optional = filmeRepository.findById(id);
		
		if(optional.isPresent()) {
			Filme filme = form.atualizar(id, filmeRepository);
			return ResponseEntity.ok(new FilmeDto(filme));
		}
		
		
		return ResponseEntity.notFound().build();
	}
	
	
	
	@DeleteMapping("{id}")
	@Transactional
	@CacheEvict(value="listaDeFilmes", allEntries=true)
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Filme> optional = filmeRepository.findById(id);
		
		if(optional.isPresent()) {
			filmeRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}
}





