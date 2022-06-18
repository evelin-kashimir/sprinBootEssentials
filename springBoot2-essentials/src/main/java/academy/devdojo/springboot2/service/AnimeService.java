package academy.devdojo.springboot2.service;

//SERVICE - TODAS AS REGRAS DE NEGÓCIO FICAM AQUI
import academy.devdojo.springboot2.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {
    public List<Anime> listAll() {
        return List.of(new Anime( 1L,"NARUTO"), new Anime(2L, "DBZ"), new Anime(3L,"BORUTO"));
    }
}

/* ANOTAÇÕES - O QUE ESTÁ ACONTECENDO...

@Service - Este bean define a classe como um serviço;
@public List<Anime> listAll() - EndPoint herdado da interface repository, listará todos os registros contentes na base de dados;

 */