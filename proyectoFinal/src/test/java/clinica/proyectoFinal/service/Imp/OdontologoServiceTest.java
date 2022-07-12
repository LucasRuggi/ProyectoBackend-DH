package clinica.proyectoFinal.service.Imp;

import clinica.proyectoFinal.model.DTO.OdontologoDTO;
import clinica.proyectoFinal.service.IOdontologoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private IOdontologoService odontologoService;

    @Test
    public void crearOdontologoTest(){
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Lucas");
        odontologoDTO.setApellido("Rushi");
        odontologoDTO.setMatricula("AA123");
        odontologoService.crear(odontologoDTO);

        OdontologoDTO odontologoLucas = odontologoService.buscarPorId(1);

        assertTrue(odontologoLucas != null);

    }

}