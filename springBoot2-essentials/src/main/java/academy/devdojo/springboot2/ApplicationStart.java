package academy.devdojo.springboot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration
//@Configuration transforma a classe de execucao em um bean de configuracao
//@ComponentScan
// (basePackages = "academy.devdojo.springboot2") //foçando o o scan passar por todos os pacotes para encontrar o endpoint
//não é necessário quando o appstart está na raiz do projeto;
@SpringBootApplication //pre configura com os padroes de uma aplicacao sprin, tira a necessidade de setarmos na mão as anotacoes acima
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }
}
