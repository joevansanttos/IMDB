package ioasys.repository;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import ioasys.modelo.Filme;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class FilmeRepositoryTest {
	
	@Autowired
	private FilmeRepository repository;
	
	@Autowired
	private TestEntityManager em;

	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloNome() {
		String nomeFilme = "Avatar";
		
		Filme avatar = new Filme();
		avatar.setNome(nomeFilme);
		avatar.setDiretor("James Cameron");
		em.persist(avatar);
		
		Filme filme = repository.findByNome(nomeFilme);
		Assert.assertNotNull(filme);
		Assert.assertEquals(nomeFilme, filme.getNome());
	}
	
	@Test
	public void naoDeveriaCarregarUmCursoCujoNomeNaoEstejaCadastrado() {
		String nomeFilme = "Nao filme";
		Filme filme = repository.findByNome(nomeFilme);
		Assert.assertNull(filme);
	}

}
