package clinica.proyectoFinal.controller;



import clinica.proyectoFinal.model.DTO.PacienteDTO;
import clinica.proyectoFinal.model.DTO.TurnoDTO;
import clinica.proyectoFinal.service.ITurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turno")
public class TurnoController {

    Logger logger = Logger.getLogger(TurnoDTO.class);

    @Autowired
    ITurnoService turnoService;

    @CrossOrigin(origins = "*")
    @PostMapping("/agregar")
    public ResponseEntity<String> agregarTurno(@RequestBody TurnoDTO turnoDTO){
        logger.info("Se agrega un turno...");
        ResponseEntity<String> res;
        if(turnoDTO.getOdontologo() == null || turnoDTO.getPaciente() == null){
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            TurnoDTO turnoCreado = turnoService.crear(turnoDTO);
            res = new ResponseEntity<>("El turno fue creado con exito. Su numero de turno es el: " + turnoCreado.getId() + ". Para el dia: " + turnoCreado.getDate() + " a las: " + turnoCreado.getTime(), HttpStatus.OK);
            logger.info("Se agrego el turno con exito.");
        }
        return res;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarTurnoPorId(@PathVariable Integer id){
        TurnoDTO turnoDTO = turnoService.buscarPorId(id);
        return new ResponseEntity<>(turnoDTO, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping()
    public ResponseEntity<Collection<TurnoDTO>> listarTurnos(){
        return ResponseEntity.ok(turnoService.listarTodos());
    }

    @CrossOrigin(origins = "*")
    @PutMapping()
    public ResponseEntity<?> modificarTurno (@RequestBody TurnoDTO turnoDTO){
        ResponseEntity<?> res;
        if(turnoService.buscarPorId(turnoDTO.getId()) == null){
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            TurnoDTO turnoModificado = turnoService.modificar(turnoDTO);
           res = new ResponseEntity<>(turnoModificado, HttpStatus.OK);
        }
        return res;
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarTurno(@PathVariable Integer id){
        ResponseEntity<String> res;
        if(turnoService.buscarPorId(id) == null){
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            turnoService.eliminar(id);
            res = new ResponseEntity<>("El turno con el id: " + id + " fue eliminado", HttpStatus.OK);
        }
        return res;
    }


}
