package clinica.proyectoFinal.model.DTO;



import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class PacienteDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String dni;
    private LocalDate fechaDeAlta;

}
