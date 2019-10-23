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
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Entity(name = "br.com.iteris.meetup.jpademo.model.Pedidodetalhe")
@Table(name = "PedidoDetalhe")
public class PedidoDetalhe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPedidoDetalhe", nullable = false)
    private Integer idPedidoDetalhe;

    @ManyToOne
    @JoinColumn(name = "IdPedido", nullable = false)
    private Pedido pedido;

    @Column(name = "QuantidadeItens", nullable = false)
    private Integer quantidadeItens;

    @ManyToOne
    @JoinColumn(name = "IdProduto", nullable = false)
    private Produto produto;

    @Column(name = "PrecoUnitario", nullable = false)
    private BigDecimal precoUnitario;

    @Column(name = "ValorTotal", nullable = false, insertable = false, updatable = false)
    private BigDecimal valorTotal;

    @Column(name = "DataModificacao", nullable = false)
    private ZonedDateTime dataModificacao;
}