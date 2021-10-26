package ioasys.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ioasys.modelo.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {

	
}
