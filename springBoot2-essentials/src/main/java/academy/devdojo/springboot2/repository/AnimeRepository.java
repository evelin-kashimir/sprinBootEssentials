package academy.devdojo.springboot2.repository;

//REPOSITORY - FAZ COMUNICAÇÃO COM O BANCO DE DADOS ATRAVÉS DOS ENDPOINTS QUE SERÃO HERDADOS NO SERVICE
import academy.devdojo.springboot2.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

}

/* ANOTAÇÕES - O QUE ESTÁ ACONTECENDO...

JpaRepository<Anime, Long>  - Fara comunicação com o banco de dados através da classe informada e seu ID;

 */