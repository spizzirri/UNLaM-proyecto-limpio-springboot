package ar.edu.unlam.tallerweb.controladores;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorBasico {

    @GetMapping(path = "/estavivo")
    public String estaVivo(){
        return "Estoy vivo";
    }
}
