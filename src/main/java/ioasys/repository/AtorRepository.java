package ioasys.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ioasys.modelo.Ator;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Long>{

	@Query("select f from Ator f join f.filmes c where c.nome = :nomeFilme")
    Page<Ator> carregarPorNomeDoFilme(@Param("nomeFilme")String nomeFilme, Pageable paginacao);
	
	@Query("select a from Ator a ")
    Page<Ator> carregarAtoresComFilmes(Pageable paginacao);

}
