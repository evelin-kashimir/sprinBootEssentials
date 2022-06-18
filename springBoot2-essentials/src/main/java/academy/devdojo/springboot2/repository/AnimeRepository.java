package academy.devdojo.springboot2.repository;

//REPOSITORY - FAZ COMUNICAÇÃO COM O BANCO DE DADOS ATRAVÉS DOS ENDPOINTS QUE SERÃO HERDADOS NO SERVICE
import academy.devdojo.springboot2.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}

/* ANOTAÇÕES - O QUE ESTÁ ACONTECENDO...

 */