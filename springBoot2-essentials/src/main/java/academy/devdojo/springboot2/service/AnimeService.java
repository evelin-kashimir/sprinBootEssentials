package academy.devdojo.springboot2.service;

//SERVICE - TODAS AS REGRAS DE NEGÓCIO FICAM AQUI
import academy.devdojo.springboot2.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {
    private static List<Anime> animes;
    static {
        animes = new ArrayList<>(List.of(new Anime( 1L,"NARUTO"), new Anime(2L, "DBZ"), new Anime(3L,"BORUTO")));
    }

    public List<Anime> listAll() {
        return animes;
    }

    public Anime findById(long id) {
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }

    public Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(3, 1000));
        animes.add(anime);
        return anime;
    }

    public void delete(long id) {
        animes.remove(findById(id));
    }
}

/* ANOTAÇÕES - O QUE ESTÁ ACONTECENDO...

Anotations
@Service - Este bean define a classe como um serviço;

EndPoinsts
static {animes = new ArrayList<>(List.of(new Anime( 1L,"NARUTO"), new Anime(2L, "DBZ"), new Anime(3L,"BORUTO")))}
A linha acima está simulando uma base de dados no banco, no caso criando um array para receber os metodos de CRUD;

LIST
public List<Anime> listAll() - EndPoint herdado da interface repository, listará todos os registros contentes na base de dados;

LIST BY ID
public Anime findById(long id) - Retorna um registro por Id;
return animes.stream() - Fatia a lista;
  .filter(anime -> anime.getId().equals(id)) - Filtra pelo id que seja igual ao passado no parâmetro;
  .findFirst() - Encontro o primeiro e traga;
  .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found")) - Caso não encontre, traz uma exceção
  com o HTTP Status de erro, e com a mesagem escolhida;

POST
public Anime save(Anime anime) - Método para inserir(salvar) dados na base de dados;
anime.setId(ThreadLocalRandom.current().nextLong(3, 1000)) - Nesse caso, como não temos conexao ao banco, precisamos simular um rand para gerar o id
animes.add(anime) - Adicionando a base de dados
return anime - Por fim retorna o que foi adicionado;

DELETE
public void delete(long id) - Removendo dados da base;
animes.remove(findById(id)) - Se encontrar algum id daquele que foi passado como parametro, deleta, se não, status 404;
                                Aqui é utilizada a mesma lógica do findById, por isso ele é chamado,para não refazer tudo;


 */