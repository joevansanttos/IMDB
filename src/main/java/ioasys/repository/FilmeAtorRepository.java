package ioasys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ioasys.modelo.FilmeAtor;

@Repository
public interface FilmeAtorRepository extends JpaRepository<FilmeAtor, Long>{



}
