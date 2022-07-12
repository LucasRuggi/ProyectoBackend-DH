package clinica.proyectoFinal.service;

import java.util.Collection;

public interface ICrudBasicService<T> {

    T crear(T t);

    T buscarPorId(Integer id);

    Collection<T> listarTodos();

    T modificar(T t);

    void eliminar(Integer id);
}
