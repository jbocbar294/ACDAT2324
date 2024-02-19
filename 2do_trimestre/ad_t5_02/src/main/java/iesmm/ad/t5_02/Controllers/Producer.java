package iesmm.ad.t5_02.Controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/producer")

public class Producer {
    // Método que produce un content type en texto plano
    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String getText() {
        return "<!doctype html><html><head><meta charset=\"utf-2\"</head><body><h1>Hola</h1></body></html>";
    }

    // Método que produce un content type en HTML
    @GetMapping(value = "/html", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getText2() {
        return "<!doctype html><html><head><meta charset=\"utf-8\"></head><body><h1>Hola</h1></body></html>";
    }


    /*
     * EJ1:
     * Calcular a partir de 2 parámetros pasados por POST, que devuelva:
     * suma, resta, multiplicación y división (mostrando operandos, operadores y
     * resultados)
     *
     * Ejemplo:
     * http://localhost:8081/ws3/opera?x=3&y=2
     *
     * Devuelve:
     * 3 + 2 = 5
     * 3 - 2 = 1
     * 3 * 2 = 6
     * 3 / 2 = 1
     *
     */
    @PostMapping("/opera") // <server>/ws3/opera?x=3&y=2
    @ResponseBody
    public String opera(@RequestParam int x, @RequestParam int y) {
        return x + " + " + y + " = " + (x + y) + "\n" + x + " - " + y + " = " + (x - y) + "\n" + x + " * " + y + " = "
                + (x * y) + "\n" + x + " / " + y + " = " + (x / y);
    }




    /*
     * EJ2:
     * Calcular a partir un parámetro de texto pasado por POST, que devuelva:
     * el número de caracteres y de palabras.
     *
     * Ejemplo:
     * http://localhost:8081/ws3/check_texto?texto=hola%20mundo
     *
     * Devuelve:
     * Texto: hola mundo con 10 caracteres y 2 palabras
     *
      */

    @PostMapping("/check_texto") // <server>/ws3/check_texto?texto=hola
    @ResponseBody
    public String comprobarTexto(@RequestParam("texto") String cad) {
        return "Texto: " + cad + " con " + cad.length() + " letras" + " y " + cad.split(" ").length
                + " palabras";
    }


    /*
     * EJ3:
     * Calcular a partir de número pasado por parámetro por POST, que devuelva
     * si es 'PAR' ó 'IMPAR', y si no es un número: 'ERROR, no es un número'
     *
     * Ejemplo 1:
     * http://localhost:8081/ws3/check_numero?numero=15
     *
     * Devuelve:
     * IMPAR
     *
     * Ejemplo 2:
     * http://localhost:8081/ws3/check_numero?numero=ab
     *
     * Devuelve:
     * ERROR, no es un número
     *
     */
    @PostMapping("/check_numero")
    @ResponseBody
    public String comprobarParidad(@RequestParam("numero") String num) {
        String msg;

        try {
            if (Integer.valueOf(num) % 2 == 0)
                msg = "PAR";
            else
                msg = "IMPAR";
        } catch (NumberFormatException e) {
            msg = "ERROR, no es un número";
        }

        return msg;
    }


    // Método que produce un content type en XML
    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String getXML() {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "<tag>" + "realización con acentos" + "</tag>";
    }

    // Método que produce un content type en JSON
    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getJSON() {
        return "{ \"nombre\":\"Ana\", \"edad\":40, \"ciudad\":\"Sevilla\" }";
    }






    /*
      * EJ1:
      * Calcular, a partir de una petición POST y la ruta /fecha,
      * para que devuelva la fecha actual en formato XML:
      * - PISTA: LocalDateTime.now()
      *
      * Ejemplo:
      * http://localhost:8080/producer/fecha
      *
      * Devuelve:
             <fecha><dia>10</dia><mes>01</mes><anio>2024</anio></fecha>
      */
    @PostMapping(value = "/fecha", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String getFechaActual() {
        LocalDateTime fecha = LocalDateTime.now();

        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "<fecha>"
                + "<dia>" + fecha.getDayOfMonth() + "</dia>"
                + "<mes>" + fecha.getMonth().getValue() + "</mes>"
                + "<anio>" + fecha.getYear() + "</anio>"
                + "</fecha>";
    }
}