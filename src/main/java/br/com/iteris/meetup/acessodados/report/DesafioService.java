package br.com.iteris.meetup.acessodados.report;

import br.com.iteris.meetup.acessodados.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Calendar.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Service
public class DesafioService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public void printVendedor() {

        System.out.println("| Nome       | Idade           |");
            vendedorRepository.findAllByOrderByNome().forEach(vendedor ->
                    System.out.println("| "  + vendedor.getNome().trim()
                    + " | " + vendedor.getIdade() + " |"));

    }
}
