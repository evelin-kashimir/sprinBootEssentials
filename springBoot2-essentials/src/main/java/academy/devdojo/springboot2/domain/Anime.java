package academy.devdojo.springboot2.domain;

//CLASSE SIMPLES - QUASE ENTIDADE - TABELA DO BANCO DE DADOS
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}

/* ANOTAÇÕES - O QUE ESTÁ ACONTECENDO...

@Data - Gera geters and seters e demais metodos especiais em forma de JSON;
@AllArgsConstructor - Gera o construtor com todos os atributos da classe;

*/
