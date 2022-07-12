package clinica.proyectoFinal.model.DTO;


import clinica.proyectoFinal.model.entity.Odontologo;
import clinica.proyectoFinal.model.entity.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class TurnoDTO {

    private Integer id;
    private LocalDate date;
    private LocalTime time;
    private Odontologo odontologo;
    private Paciente paciente;

}
