package academy.devdojo.springboot2.service;

//SERVICE - TODAS AS REGRAS DE NEGÓCIO FICAM AQUI
import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.dto.AnimePostDTO;
import academy.devdojo.springboot2.dto.AnimePutDTO;
import academy.devdojo.springboot2.exception.BadRequestException;
import academy.devdojo.springboot2.mapper.AnimeMapper;
import academy.devdojo.springboot2.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime not Found"));
    }

    public Anime save(AnimePostDTO animePostDTO) {
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostDTO));
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutDTO animePutDTO) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutDTO.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutDTO);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }
}

/* ANOTAÇÕES - O QUE ESTÁ ACONTECENDO...

Anotations
@Service - Este bean define a classe como um serviço;
@RequiredArgsConstructor - Cria os construtores necessários;

EndPoinsts
static {animes = new ArrayList<>(List.of(new Anime( 1L,"NARUTO"), new Anime(2L, "DBZ"), new Anime(3L,"BORUTO")))}
A linha acima está simulando uma base de dados no banco, no caso criando um array para receber os metodos de CRUD;

LIST
return animeRepository.findAll();- EndPoint herdado da interface repository, listará todos os registros contentes na base de dados;

LIST BY ID
public Anime findById(long id) - Retorna um registro por Id;
return animeRepository.stream() - Fatia a lista;
  .filter(anime -> anime.getId().equals(id)) - Filtra pelo id que seja igual ao passado no parâmetro;
  .findFirst() - Encontro o primeiro e traga;
  .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found")) - Caso não encontre, traz uma exceção
  com o HTTP Status de erro, e com a mesagem escolhida;

Este aqui faz o mesmo porém para o banco de dados
public Anime findById(long id) {
return animeRepository.findById(id)
.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));


POST
public Anime save(Anime anime) - Método para inserir(salvar) dados na base de dados;
anime.setId(ThreadLocalRandom.current().nextLong(3, 1000)) - Nesse caso, como não temos conexao ao banco, precisamos simular um rand para gerar o id
animes.add(anime) - Adicionando a base de dados
return anime - Por fim retorna o que foi adicionado;

Esta linha faz o mesmo do metodo acima
return animeRepository.save(Anime.builder().name(animeDtoRequestBody.getName()).build()) - Aqui está sendo salvo o dto;

DELETE
public void delete(long id) - Removendo dados da base;
animes.remove(findById(id)) - Se encontrar algum id daquele que foi passado como parametro, deleta, se não, status 404;
                                Aqui é utilizada a mesma lógica do findById, por isso ele é chamado,para não refazer tudo;

UPDATE
public void replace(Anime anime) - Atualizando o objeto da base
delete(anime.getId()) - Neste caso como não temos conexao ao banco, é necessária a deleção e uma nova criação do mesmo objeto através do id;
animes.add(anime);

 */