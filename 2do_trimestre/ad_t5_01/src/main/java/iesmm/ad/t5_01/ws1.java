package iesmm.ad.t5_01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/ws1")
public class ws1 {

    private final Logger logTag = Logger.getLogger("AD");

    public ws1() {
        logTag.log(Level.INFO, "WebService instancia cargada " + this);
    }

    @GetMapping
    @ResponseBody //para indicar que el resultado del método lo vuelque en el cuerpo de la respuesta HTTP
    public String get() {
        logTag.log(Level.INFO, "Petición GET resuelta " + this);
        return "Esto ha sido una respuesta de GET";
    }

    @PostMapping
    @ResponseBody //para indicar que el resultado del método lo vuelque en el cuerpo de la respuesta HTTP
    public String post() {
        logTag.log(Level.INFO, "Petición POST resuelta " + this);
        return "Esto ha sido una respuesta de POST";
    }

    @PostMapping({"/s2", "post2"})
    @ResponseBody //para indicar que el resultado del método lo vuelque en el cuerpo de la respuesta HTTP
    public String post2() {
        logTag.log(Level.INFO, "Petición POST resuelta " + this);
        return "Esto ha sido una respuesta de POST s2";
    }


    /* EJERCICIO DE CLASE:
        Calcular a partir de una petición GET que devuelva la fecha y hora actual en el siguiente formato:

        "Hoy es DD/MM/YYYY y son las HH:MM:SS"

        Petición URL: http://localhost:port/ws1/fecha
     */

    @GetMapping("/fecha")
    @ResponseBody //para indicar que el resultado del método lo vuelque en el cuerpo de la respuesta HTTP
    public String getFecha() {
        logTag.log(Level.INFO, "Petición GET resuelta " + this);

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");

        return "Hoy es " + localDateTime.format(formatoFecha) + " y son las " + localDateTime.format(formatoHora);
    }
}
