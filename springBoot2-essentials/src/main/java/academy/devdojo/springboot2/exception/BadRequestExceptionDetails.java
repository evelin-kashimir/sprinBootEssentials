package academy.devdojo.springboot2.exception;

//ATRIBUTOS QUE SERAM UTILIZADOS PARA PERSONALIZAR A MENSAGEM DO HTTP BADREQUEST
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BadRequestExceptionDetails {
    private String title;
    private int status;
    private String details;
    private String developerMessage;
    private LocalDateTime timeStamp;
}
