package teste.exemplo.datosdeportivosapi.repository;

import teste.exemplo.datosdeportivosapi.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    List<Cliente> findByStatus(boolean status);

}
