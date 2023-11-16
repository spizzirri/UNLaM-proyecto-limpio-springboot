package ar.edu.unlam.tallerweb.controladores;

import ar.edu.unlam.tallerweb.servicios.ServicioInquilinos;
import ar.edu.unlam.tallerweb.modelos.Inquilino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorInquilinos {

    private ServicioInquilinos servicioInquilino;

    @Autowired
    public ControladorInquilinos(ServicioInquilinos servicioInquilinos){
        this.servicioInquilino = servicioInquilinos;
    }

    @GetMapping(path = "/inquilinos")
    public ResponseEntity<List<Inquilino>> obtenerInquilinos(){
        List<Inquilino> inquilinos = this.servicioInquilino.consultarInquilinos();
        if(inquilinos.isEmpty()){
            return ResponseEntity.noContent().build();
             //new ResponseEntity(inquilinos, HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(inquilinos, HttpStatus.OK);
        }
    }

    @PostMapping(path = "/inquilinos")
    public Long crearInquilino(@RequestBody Inquilino inquilino){
        return this.servicioInquilino.crearInquilino(inquilino);
    }
}
