package ar.edu.unlam.tallerweb.servicios;
import ar.edu.unlam.tallerweb.modelos.Inquilino;

import java.util.List;

public interface ServicioInquilinos {
    public Long crearInquilino(Inquilino inquilino);
    public List<Inquilino> consultarInquilinos();
}
