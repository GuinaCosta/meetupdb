package br.com.iteris.meetup.acessodados.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Data
@Entity(name = "br.com.iteris.meetup.jpademo.model.Vendedortelefone")
@Table(name = "VendedorTelefone")
public class VendedorTelefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdVendedorTelefone", nullable = false)
    private Integer idVendedorTelefone;

    @ManyToOne
    @JoinColumn(name = "IdVendedor", nullable = false)
    private Vendedor vendedor;

    @Column(name = "Telefone", nullable = false)
    private String telefone;

    @Column(name = "DataModificacao", nullable = false)
    private ZonedDateTime dataModificacao;
}