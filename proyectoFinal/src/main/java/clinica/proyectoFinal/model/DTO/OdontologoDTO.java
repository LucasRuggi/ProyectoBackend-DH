package clinica.proyectoFinal.model.DTO;

import clinica.proyectoFinal.model.entity.Turno;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
public class OdontologoDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    private String matricula;


}
