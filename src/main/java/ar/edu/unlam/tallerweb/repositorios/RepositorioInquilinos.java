package ar.edu.unlam.tallerweb.repositorios;

import ar.edu.unlam.tallerweb.modelos.Inquilino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioInquilinos extends JpaRepository<Inquilino, Long> {
}
