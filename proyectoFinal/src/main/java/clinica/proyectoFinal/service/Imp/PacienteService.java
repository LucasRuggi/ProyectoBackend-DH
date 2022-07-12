package clinica.proyectoFinal.service.Imp;


import clinica.proyectoFinal.model.DTO.PacienteDTO;
import clinica.proyectoFinal.model.entity.Paciente;
import clinica.proyectoFinal.repository.IPacienteRepository;
import clinica.proyectoFinal.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public PacienteDTO crear(PacienteDTO pacienteDTO) {
        Paciente paciente = mapEntity(pacienteDTO);
        paciente.setFechaDeAlta(LocalDate.now());
        return mapDTO(pacienteRepository.save(paciente));
    }

    @Override
    public PacienteDTO buscarPorId(Integer id) {
        PacienteDTO pacienteDTO = null;
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        if(pacienteOptional.isPresent()){
            pacienteDTO = mapper.convertValue(pacienteOptional, PacienteDTO.class);
        }
        return pacienteDTO;
    }

    @Override
    public Collection<PacienteDTO> listarTodos() {
        List<Paciente> pacienteList = pacienteRepository.findAll();
        Set<PacienteDTO> pacienteDTOSet = new HashSet<>();
        for(Paciente paciente : pacienteList){
            pacienteDTOSet.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacienteDTOSet;
    }

    @Override
    public PacienteDTO modificar(PacienteDTO pacienteDTO) {
        Paciente paciente = mapEntity(pacienteDTO);
        return mapDTO(pacienteRepository.save(paciente));
    }

    @Override
    public void eliminar(Integer id) {
        pacienteRepository.deleteById(id);
    }

    private PacienteDTO mapDTO(Paciente paciente){
        return mapper.convertValue(paciente, PacienteDTO.class);
    }

    public Paciente mapEntity(PacienteDTO pacienteDTO){
        return mapper.convertValue(pacienteDTO, Paciente.class);
    }
}
