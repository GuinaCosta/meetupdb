package br.com.iteris.meetup.acessodados.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Entity(name = "br.com.iteris.meetup.jpademo.model.Produto")
@Table(name = "Produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProduto", nullable = false)
    private Integer idProduto;

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "Custo", nullable = false)
    private BigDecimal custo;

    @Column(name = "Tamanho")
    private String tamanho;

    @Column(name = "Peso")
    private BigDecimal peso;

    @Column(name = "ThumbNail")
    private String thumbnail;

    @Column(name = "ArquivoThumbnail")
    private String arquivoThumbnail;

    @Column(name = "FotoGrande")
    private String fotoGrande;

    @Column(name = "ArquivoFotoGrande")
    private String arquivoFotoGrande;

    @Column(name = "DataModificacao", nullable = false)
    private ZonedDateTime dataModificacao;

    @OneToMany(mappedBy = "produto")
    private List<PedidoDetalhe> pedidosDetalhe;
}