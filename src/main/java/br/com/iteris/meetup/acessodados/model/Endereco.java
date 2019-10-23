package br.com.iteris.meetup.acessodados.model;

import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Entity(name = "br.com.iteris.meetup.jpademo.model.Endereco")
@Table(name = "Endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEndereco", nullable = false)
    private Integer idEndereco;

    @ManyToOne
    @JoinColumn(name = "IdVendedor")
    private Vendedor vendedor;

    @Column(name = "Descricao", nullable = false)
    private String descricao;

    @Column(name = "Cidade", nullable = false)
    private String cidade;

    @Column(name = "Estado", nullable = false)
    private String estado;

    @Column(name = "Cep", nullable = false)
    private String cep;

    @Column(name = "DataModificacao", nullable = false)
    private ZonedDateTime dataModificacao;

    @OneToMany(mappedBy = "enderecoEnvio")
    private List<Pedido> pedidos;

}