package academy.devdojo.springboot2.service;

//SERVICE - TODAS AS REGRAS DE NEGÓCIO FICAM AQUI
import academy.devdojo.springboot2.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AnimeService {
    private List<Anime> animes = List.of(new Anime( 1L,"NARUTO"), new Anime(2L, "DBZ"), new Anime(3L,"BORUTO"));

    public List<Anime> listAll() {
        return animes;
    }

    public Anime findById(long id) {
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }
}

/* ANOTAÇÕES - O QUE ESTÁ ACONTECENDO...

Anotations
@Service - Este bean define a classe como um serviço;

EndPoinsts
public List<Anime> listAll() - EndPoint herdado da interface repository, listará todos os registros contentes na base de dados;

public Anime findById(long id) - Retorna um registro por Id;
return animes.stream() - Fatia a lista;
  .filter(anime -> anime.getId().equals(id)) - Filtra pelo id que seja igual ao passado no parâmetro;
  .findFirst() - Encontro o primeiro e traga;
  .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found")) - Caso não encontre, traz uma exceção
  com o HTTP Status de erro, e com a mesagem escolhida;

 */