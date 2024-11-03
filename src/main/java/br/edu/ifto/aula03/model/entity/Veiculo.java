package br.edu.ifto.aula03.model.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.NumberFormat;
import java.math.BigDecimal;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;

//    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal preco;

    private String anoFabricacao;

    public Veiculo() {}

    public Veiculo(Long id, Modelo modelo, BigDecimal preco, String anoFabricacao) {
        this.id = id;
        this.modelo = modelo;
        this.preco = preco;
        this.anoFabricacao = anoFabricacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
}
