package academy.devdojo.springboot2;

//CLASSE QUE DÁ O START NA APLICAÇÃO TRAZ TODAS AS CONFIGURAÇÕES NECESSÁRIAS PARA SUBIR O SERVIDOR (GERADA PELO SPRING.IO);
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot2EssentialsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2EssentialsApplication.class, args);
	}
}
