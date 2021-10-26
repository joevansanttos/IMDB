package ioasys.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ioasys.modelo.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

	//List<Filme> findByAtorNome(String nomeAtor);
	
	@Query("select f from Filme f order by f.nome")
    Page<Filme> carregarTodosFilmes(Pageable paginacao);
	
	@Query("select f from Filme f join f.atores c where c.nome = :nomeAtor")
    Page<Filme> carregarPorNomeDoAtor(@Param("nomeAtor")String nomeAtor, Pageable paginacao);
	
	@Query("select f from Filme f where f.diretor = :diretor")
	Page<Filme> carregarPorDiretor(@Param("diretor")String diretor, Pageable paginacao);
	
	@Query("select f from Filme f where f.genero = :genero")
	Page<Filme> carregarPorGenero(@Param("genero")String genero, Pageable paginacao);
	
	Filme findByNome(String nomeFilme);

	
}
