package clinica.proyectoFinal.controller;


import clinica.proyectoFinal.model.DTO.OdontologoDTO;
import clinica.proyectoFinal.service.IOdontologoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/odontologo")
public class OdontologoController {


    Logger logger = Logger.getLogger(OdontologoDTO.class);

    @Autowired
    IOdontologoService odontologoService;


    @PostMapping("/agregar")
    public ResponseEntity<?> agregarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        logger.info("Se agrega un odontologo...");
        ResponseEntity<?> res;
        if(odontologoDTO.getMatricula().isEmpty() || odontologoDTO.getNombre().isEmpty() || odontologoDTO.getApellido().isEmpty()){
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            OdontologoDTO odontologoCrear = odontologoService.crear(odontologoDTO);
            res = new ResponseEntity<>(odontologoCrear, HttpStatus.OK);
            logger.info("Se agrego el odontologo con exito");
        }
        return res;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarOdontologoPorId(@PathVariable Integer id){
        OdontologoDTO odontologoDTO = odontologoService.buscarPorId(id);
        return new ResponseEntity<>(odontologoDTO, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping()
    public ResponseEntity<Collection<OdontologoDTO>> listarOdontologos() {
        return ResponseEntity.ok(odontologoService.listarTodos());
    }

    @CrossOrigin(origins = "*")
    @PutMapping()
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        ResponseEntity<?> res;
        if(odontologoService.buscarPorId(odontologoDTO.getId()) == null){
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            OdontologoDTO odontologoModificado = odontologoService.modificar(odontologoDTO);
            res = new ResponseEntity<>(odontologoModificado, HttpStatus.OK);
        }
        return res;
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarOdontologo(@PathVariable Integer id){
        ResponseEntity<String> res;
        if(odontologoService.buscarPorId(id) == null){
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            odontologoService.eliminar(id);
            res = new ResponseEntity<>("El odontologo con id: " + id + " fue eliminado.", HttpStatus.OK);
        }
        return res;
    }



}
