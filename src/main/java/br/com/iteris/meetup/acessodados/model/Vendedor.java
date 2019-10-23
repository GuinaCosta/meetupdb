package br.com.iteris.meetup.acessodados.model;

import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

@Data
@Entity(name = "br.com.iteris.meetup.jpademo.model.Vendedor")
@Table(name = "Vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdVendedor", nullable = false)
    private Integer idVendedor;

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "DataNascimento", nullable = true)
    private LocalDate dataNascimento;

    @Column(name = "DataModificacao", nullable = false)
    private ZonedDateTime dataModificacao;

    @OneToMany(mappedBy = "vendedor")
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "vendedor")
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "vendedor")
    private List<VendedorTelefone> telefones;

    @Formula("((CONVERT(int,CONVERT(char(8),GETDATE(),112))-CONVERT(char(8),DataNascimento,112))/10000)")
    private Integer idade;

    /*public int getDiffYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(YEAR) - a.get(YEAR);
        if (a.get(MONTH) > b.get(MONTH) ||
                (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
            diff--;
        }
        return diff;
    }

    public Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }*/

}