package br.com.iteris.meetup.acessodados.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Entity(name = "br.com.iteris.meetup.jpademo.model.Pedido")
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPedido", nullable = false)
    private Integer idPedido;

    @Column(name = "DataPedido", nullable = false)
    private LocalDateTime dataPedido;

    @Column(name = "Status", nullable = false)
    private Byte status;

    @Column(name = "IdCliente", nullable = false)
    private Integer idCliente;

    @ManyToOne
    @JoinColumn(name = "IdVendedor")
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "IdEnderecoEnvio", nullable = false)
    private Endereco enderecoEnvio;

    @Column(name = "SubTotal", nullable = false)
    private BigDecimal subtotal;

    @Column(name = "ValorImposto", nullable = false)
    private BigDecimal valorImposto;

    @Column(name = "ValorFrete", nullable = false)
    private BigDecimal valorFrete;

    @Column(name = "ValorTotal", insertable = false, updatable = false)
    private BigDecimal valorTotal;

    @Column(name = "DataModificacao", nullable = false)
    private ZonedDateTime dataModificacao;

    @OneToMany(mappedBy = "pedido")
    private List<PedidoDetalhe> detalhes;
}