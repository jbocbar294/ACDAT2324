package iesmm.ad.t5_01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ws2")
public class ws2 {

    // URI: <server>/ws2/XXXXX -> "Hola XXXXX"
    @GetMapping("/{nombre}")
    @ResponseBody
    public String saludo(@PathVariable String nombre) {
        return "Hola " + nombre;
    }

    // URI: <server>/ws2/codigo/432 -> "El número es 234"
    @GetMapping("/codigo/{numero:\\d+}")
    @ResponseBody
    public String getNumero(@PathVariable String numero) {
        return "El número es " + numero;
    }

    // URI: <server>/ws2/codigo/ac-432 -> "El número es ac-432"
    // Debe seguir el patrón: XX-000

    // URI: <server>/ws2/codigo/432 -> "El número es 234"
    @GetMapping("/codigo/{cod: [a-z][a-z][-]\\d{3}}")
    @ResponseBody
    public String getNumeroPatron(@PathVariable String cod) {
        return "El número es " + cod;
    }


    // 12-02
    /*
     * EJ1:
     * Calcular a partir de una petición POST y del parámetro de la URL
     * un número factorial de un número mayor que 1
     */
    // URI: <server>/ws2/factorial/5 -> "El factorial es: 120"

    @PostMapping("/factorial/{numero:\\d+}")
    @ResponseBody
    public String factorial(@PathVariable String numero) {
        int num = Integer.parseInt(numero);
        int factorial = 1;
        String res = "";

        if (Integer.parseInt(numero) < 1) {
            res = "Debes introducir un número mayor a 0.";
        } else {
            for (int i = 1; i<=num; i++) {
                factorial*=i;
            }
            res = "El factorial de " + numero + " es " + factorial;
        }
        return res;
    }

    /*
     * EJ2:
     * Calcular a partir de una petición POST y del parámetro de la URL
     * el número de digitos pasado (puede haber letras)
     */
    // URI: <server>/ws2/digitos/aa8b001 -> "aa8b001 tiene 4 dígitos"
    @PostMapping("/digitos/{cod}") // URI: <server>/ws2/digitos/aa8b001 -> "aa8b001 tiene 4 dígitos"
    @ResponseBody
    public String calcularDigitos(@PathVariable("cod") String cad) {
        int ndigitos = 0;

        for (int i = 0; i < cad.length(); i++)
            if (cad.charAt(i) >= '0' && cad.charAt(i) <= '9') // (cad.charAt(i) >= 48 && cad.charAt(i) <= 57)
                ndigitos++;

        return cad + " tiene " + ndigitos + " dígitos";
    }


    /*
     * EJ3:
     * Calcular a partir de una petición GET y de los parámetros
     * anio/mes/dia la fecha correspondiente: Por ejemplo si pasa <URL
     * principal>/2020/02/10 deberá devolver: La fecha es: 10/02/2020 con el formato
     * DD/MM/YYYY
     */
    // URI: <server>/ws2/2020/02/10 -> "La fecha es: 10/02/2020"
    @GetMapping("/{anio:\\d{4}}/{mes:\\d{2}}/{dia:\\d{2}}")
    @ResponseBody
    public String getFecha(@PathVariable String anio, @PathVariable String mes, @PathVariable String dia) {
        return "La fecha es: " + dia + "/" + mes + "/" + anio;
    }

}