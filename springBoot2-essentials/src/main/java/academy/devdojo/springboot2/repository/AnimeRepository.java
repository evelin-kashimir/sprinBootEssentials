package academy.devdojo.springboot2.repository;

//REPOSITORY - FAZ COMUNICAÇÃO COM O BANCO DE DADOS ATRAVÉS DOS ENDPOINTS QUE SERÃO HERDADOS NO SERVICE
import academy.devdojo.springboot2.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
    List<Anime> findByName(String name);
}

/* ANOTAÇÕES - O QUE ESTÁ ACONTECENDO...

JpaRepository<Anime, Long>  - Fara comunicação com o banco de dados através da classe informada e seu ID;
List<Anime> findByName(String name) - Fazendo uma busca por nome;
 */