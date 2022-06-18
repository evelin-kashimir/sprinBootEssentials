package academy.devdojo.springboot2;

//CLASSE QUE DÁ O START NA APLICAÇÃO TRAZ TODAS AS CONFIGURAÇÕES NECESSÁRIAS PARA SUBIR O SERVIDOR
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }
}


/* ANOTAÇÕES - O QUE ESTÁ ACONTECENDO...

Anotations
@Configuration - Transforma a classe de execucao em um bean de configuracao;
@ComponentScan(basePackages = "academy.devdojo.springboot2") - Forçando o scan passar por todos os pacotes para encontrar o endpoint,
                                                                isso não é necessário quando o appstart está na raiz do projeto;
@SpringBootApplication - Pré configura com os padroes de uma aplicacao sprinG, tira a necessidade de setarmos na mão as anotacoes acima;
 */