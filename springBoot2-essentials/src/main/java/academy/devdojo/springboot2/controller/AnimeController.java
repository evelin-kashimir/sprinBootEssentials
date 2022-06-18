package academy.devdojo.springboot2.controller;

//CONTROLER FICAM TODOS OS ENDPOINTS;
import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.dto.AnimePostDTO;
import academy.devdojo.springboot2.dto.AnimePutDTO;
import academy.devdojo.springboot2.service.AnimeService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
    private final DateUtil dateUtil;
    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(animeService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findByid(@PathVariable long id){
        return ResponseEntity.ok(animeService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody AnimePostDTO anime){
        return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AnimePutDTO animePutDTO){
        animeService.replace(animePutDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

/* ANOTAÇÕES - O QUE ESTÁ ACONTECENDO...

Anotations
@RequestMapping(method = RequestMethod.GET, path = "list") - Dá acesso ao localhost:8080/+ Class + os endpoints como parametros;
@RequestMapping("animes") - Dá acesso a todos o s endpoints da classe continos no service;
@GetMapping(path = "list") - Faz o mesmo que o @RequestMapping, porém de uma forma mais clean;
@AllArgsConstructor - Constroi um contrutor com todos os atributos da classe;
@RestController - Define essa classe como controller e todos os métodos teram @ResponseBy, definindo todos os retornos como string(JSON);
@RequiredArgsConstructor - Constroi um contrutor com todos os atributos da classe até mesmo as constantes (final);
@Log4j2 - Traz uma lib de log implantada pelo lombok;

EndPoints
public List<Anime> list(){ - Retorna uma lista de animes;
log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now())) Trazendo no log a data da inicialização do que aparece na página;
return animeService.listAll(); Implementa o método que está no service com a lógica de negócio;
new ResponseEntity<>(animeService.listAll(), HttpStatus.OK) - Traz o status HTTP da página;
ResponseEntity.ok(animeService.listAll()) - Faz o mesmo da linha acima, porém mais simplificado e clean;

@GetMapping(path = "/{id}") - animes + /id URL que será mapeada;
public ResponseEntity<Anime> findByid(@PathVariable long id) - Parametro que será utilizado na URL;
return ResponseEntity.ok(animeService.findById(id)) - Trazendo o registro encontrado com o id passado no parametro da URL;

@PostMapping - Inserir dados na base;
public ResponseEntity<Anime> save(@RequestBody Anime anime) - Utilizara um formulário, o que estiver no Body, será utilizado na requisição;
return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED) - Salvando na base e retornando o status 201;

@DeleteMapping(path = "/{id}") -  animes + /id URL que será mapeada e excluida;
public ResponseEntity<Void> delete(@PathVariable long id) - Parametro que será utilizado na URL;
animeService.delete(id) - Deleta o id que foi inserido no parametro da URL;
return new ResponseEntity<>(HttpStatus.NO_CONTENT) - Retorna o status de exclusão 204;

@PutMapping - Atualiza dados da base;
public ResponseEntity<Void> replace(@RequestBody Anime anime) - Requisição através do body(formulário0 do objeto que será registrado;
animeService.replace(anime) - Chamando o metodo para finalizar a atualização

*/
