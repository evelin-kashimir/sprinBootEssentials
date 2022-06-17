package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController //Define essa classe como controller e todos os métodos teram @ResponseBy, definindo todos os retornos como string(JSON);
@RequestMapping("anime") //quando acessar anime, acessará o endpoint list;
@Log4j2
@RequiredArgsConstructor // constroi um contrutor com todos os atributos da classe até mesmo as constantes (final);
//@AllArgsConstructor constroi um contrutor com todos os atributos da classe;
public class AnimeController {
    private final DateUtil dateUtil;

    //End Point que retorna uma lista de animes
    //@RequestMapping(method = RequestMethod.GET, path = "list") //o mesmo que = localhost:8080/list
    @GetMapping(path = "list") //faz o mesmo, porém de uma forma mais clean
    public List<Anime> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now())); //trazendo no log a data da inicialização do que aparece na página
        return List.of(new Anime("NARUTO"), new Anime("DBZ"));
    }

}

