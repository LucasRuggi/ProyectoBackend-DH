package clinica.proyectoFinal.repository;

import clinica.proyectoFinal.model.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository<Turno, Integer> {
}
