package clinica.proyectoFinal.service.Imp;

import clinica.proyectoFinal.model.DTO.TurnoDTO;
import clinica.proyectoFinal.model.entity.Turno;
import clinica.proyectoFinal.repository.ITurnoRepository;
import clinica.proyectoFinal.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public TurnoDTO crear(TurnoDTO turnoDTO) {
        Turno turno = mapEntity(turnoDTO);
        return mapDTO(turnoRepository.save(turno));
    }

    @Override
    public TurnoDTO buscarPorId(Integer id) {
        TurnoDTO turnoDTO = null;
        Optional<Turno> turnoOptional= turnoRepository.findById(id);
        if(turnoOptional.isPresent()){
            turnoDTO = mapper.convertValue(turnoOptional, TurnoDTO.class);
        }
        return turnoDTO;
    }

    @Override
    public Collection<TurnoDTO> listarTodos() {
        List<Turno> turnoList = turnoRepository.findAll();
        Set<TurnoDTO> turnoDTOSet = new HashSet<>();
        for(Turno turno : turnoList){
            turnoDTOSet.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnoDTOSet;
    }

    @Override
    public TurnoDTO modificar(TurnoDTO turnoDTO) {
        Turno turno = mapEntity(turnoDTO);
        return mapDTO(turnoRepository.save(turno));
    }

    @Override
    public void eliminar(Integer id) {
        turnoRepository.deleteById(id);
    }

    private TurnoDTO mapDTO(Turno turno){
        return mapper.convertValue(turno, TurnoDTO.class);
    }

    public Turno mapEntity(TurnoDTO turnoDTO){
        return mapper.convertValue(turnoDTO, Turno.class);
    }
}
