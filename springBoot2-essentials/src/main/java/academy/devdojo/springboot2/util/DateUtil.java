package academy.devdojo.springboot2.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component //transformando a classe em um component
public class DateUtil {
    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime){
        //retorna uma data formatada
        return DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss").format(localDateTime);
    }
}
