package academy.devdojo.springboot2.controller;

//CONTROLER FICAM TODOS OS ENDPOINTS;
import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.service.AnimeService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Anime> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return animeService.listAll();
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

*/
