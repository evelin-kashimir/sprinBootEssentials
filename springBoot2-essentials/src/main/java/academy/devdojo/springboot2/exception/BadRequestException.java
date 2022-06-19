package academy.devdojo.springboot2.exception;

//CLASSE PRA TRATAR EXCEÇÕES DE ERROS CUSTOMIZADAS
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}


/* ANOTAÇÕES - O QUE ESTÁ ACONTECENDO...

@ResponseStatus(HttpStatus.BAD_REQUEST) - Anotation para retornar um http status de erro;


public class BadRequestException extends RuntimeException - A classe extende de TuntimeException (Excessões que compilam, mas retornam erro);
public BadRequestException(String message) - Trazendo uma mensagem de erro que será customizada por mim;
super(message) - Utilizando o método já implementado por padrão na super (RunTimeException);

}
 */