package academy.devdojo.springboot2.domain;

//CLASSE SIMPLES - QUASE ENTIDADE - TABELA DO BANCO DE DADOS
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Anime {
    private Long id;
    private String name;

}

/* ANOTAÇÕES - O QUE ESTÁ ACONTECENDO...

@Data - Gera geters and seters e demais metodos especiais em forma de JSON;
@AllArgsConstructor - Gera o construtor com todos os atributos da classe;

*/
