package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Define essa classe como controller e todos os métodos teram @ResponseBy, definindo todos os retornos como string(JSON)
@RequestMapping("anime") //quando acessar anime, acessará o endpoint list
public class AnimeController {

    //End Point que retorna uma lista de animes
    //@RequestMapping(method = RequestMethod.GET, path = "list") //o mesmo que = localhost:8080/list
    @GetMapping(path = "list") //faz o mesmo, porém de uma forma mais clean
    public List<Anime> list(){
        return List.of(new Anime("NARUTO"), new Anime("DBZ"));
    }
}
