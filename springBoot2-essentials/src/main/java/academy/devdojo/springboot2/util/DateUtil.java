package academy.devdojo.springboot2.util;

//UTIL - FICAM TODOS OS UTILITÁRIOS, METODOS DE FORMATAÇÃO E ETC;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtil {
    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss").format(localDateTime);
    }
}


/* ANOTAÇÕES - O QUE ESTÁ ACONTECENDO...

Anotations
@Component - Este bean transforma a classe em um component

public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime) - Método que traz a classe de datas LocalDateTime;
return DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss").format(localDateTime) - Retorno de data formatada;
*/