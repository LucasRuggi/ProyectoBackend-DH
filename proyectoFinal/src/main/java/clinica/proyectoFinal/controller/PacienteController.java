package clinica.proyectoFinal.controller;


import clinica.proyectoFinal.model.DTO.OdontologoDTO;
import clinica.proyectoFinal.model.DTO.PacienteDTO;
import clinica.proyectoFinal.service.IPacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.util.Collection;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    Logger logger = Logger.getLogger(PacienteDTO.class);

    @Autowired
    IPacienteService pacienteService;

    @CrossOrigin(origins = "*")
    @PostMapping("/agregar")
    public ResponseEntity<?> agregarPaciente(@RequestBody PacienteDTO pacienteDTO){
        logger.info("Se agrega un paciente...");
        ResponseEntity<?> res;
        if(pacienteDTO.getNombre().isEmpty() || pacienteDTO.getApellido().isEmpty() || pacienteDTO.getDni().isEmpty() || pacienteDTO.getDomicilio().isEmpty()){
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            PacienteDTO pacienteCreado = pacienteService.crear(pacienteDTO);
            res = new ResponseEntity<>(pacienteCreado, HttpStatus.OK);
            logger.info("Se agrego un paciente con exito.");
        }
        return res;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPacientePorId(@PathVariable Integer id){
        PacienteDTO pacienteDTO = pacienteService.buscarPorId(id);
        return ResponseEntity.ok(pacienteDTO);
    }

    @CrossOrigin(origins = "*")
    @GetMapping()
    public ResponseEntity<Collection<PacienteDTO>> listarTodosPacientes() {
        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    @CrossOrigin(origins = "*")
    @PutMapping()
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO){
        ResponseEntity<?> res;
        if(pacienteService.buscarPorId(pacienteDTO.getId()) == null){
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            PacienteDTO pacienteModificado = pacienteService.modificar(pacienteDTO);
            res = new ResponseEntity<>(pacienteModificado, HttpStatus.OK);
        }
            return res;
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPaciente(@PathVariable Integer id){
        ResponseEntity<String> res;
        if(pacienteService.buscarPorId(id) == null){
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            pacienteService.eliminar(id);
            res = new ResponseEntity<>("El paciente con id: " + id + " fue eliminado", HttpStatus.OK);
        }
        return res;
    }





}
