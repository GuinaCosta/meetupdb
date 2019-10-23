package br.com.iteris.meetup.acessodados.repository;

import br.com.iteris.meetup.acessodados.model.Vendedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Integer> {

    List<Vendedor> findAllByOrderByNome();

}
