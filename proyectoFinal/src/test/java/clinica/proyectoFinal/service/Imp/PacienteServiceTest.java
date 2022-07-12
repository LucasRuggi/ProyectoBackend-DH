package clinica.proyectoFinal.service.Imp;

import clinica.proyectoFinal.model.DTO.PacienteDTO;
import clinica.proyectoFinal.service.IPacienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private IPacienteService pacienteService;

    @Test
    public void crearPacienteTest(){
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Alan");
        pacienteDTO.setApellido("Perez");
        pacienteDTO.setDomicilio("casa");
        pacienteDTO.setDni("12345678");

        pacienteService.crear(pacienteDTO);

        PacienteDTO pacienteAlan = pacienteService.buscarPorId(1);

        assertTrue(pacienteAlan != null);

    }

}