package iesmm.ad.t5_01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ws3")
public class ws3 {

    // URI: <server>/ws3/add?nombre=juanma&edad=19
    @GetMapping("/add")
    @ResponseBody
    public String getNombre(@RequestParam String nombre, @RequestParam int edad) {
        return "Mi nombre es " + nombre + " y mi edad es " + edad;
    }

    // Ahora en la URL tenemos nombre y edad pero en las variables del método tienen un nombre distinto
    @GetMapping("/add2")
    @ResponseBody
    public String getNombre2(@RequestParam("nombre") String name, @RequestParam("edad") int age) {
        return "Mi nombre es " + name + " y mi edad es " + age;
    }


    // URI: <server>/ws3/suma?x=3&y=2
    @GetMapping("/suma") // <server>/ws3/suma?x=3&y=2
    @ResponseBody
    public String operaSuma(@RequestParam("x") int num1, @RequestParam("y") int num2) {
        return num1 + " + " + num2 + " = " + (num1 + num2);
    }
}