package clinica.proyectoFinal.service.Imp;


import clinica.proyectoFinal.model.DTO.OdontologoDTO;
import clinica.proyectoFinal.model.entity.Odontologo;
import clinica.proyectoFinal.repository.IOdontologoRepository;
import clinica.proyectoFinal.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public OdontologoDTO crear(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapEntity(odontologoDTO);
        return mapDTO(odontologoRepository.save(odontologo));
    }

    @Override
    public OdontologoDTO buscarPorId(Integer id) {
        OdontologoDTO odontologoDTO = null;
        Optional<Odontologo> odontologoOptional = odontologoRepository.findById(id);
        if(odontologoOptional.isPresent()){
            odontologoDTO = mapper.convertValue(odontologoOptional, OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    @Override
    public Collection<OdontologoDTO> listarTodos() {
        List<Odontologo> odontologoList = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTO = new HashSet<>();
        for(Odontologo odontologo : odontologoList){
            odontologoDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologoDTO;
    }

    @Override
    public OdontologoDTO modificar(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapEntity(odontologoDTO);
        return mapDTO(odontologoRepository.save(odontologo));
    }

    @Override
    public void eliminar(Integer id) {
        odontologoRepository.deleteById((id));}

    public Odontologo mapEntity(OdontologoDTO odontologoDTO){return mapper.convertValue(odontologoDTO,
            Odontologo.class);}

    private OdontologoDTO mapDTO(Odontologo odontologo){return mapper.convertValue(odontologo, OdontologoDTO.class);}
}
