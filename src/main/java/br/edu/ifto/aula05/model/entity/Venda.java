package br.edu.ifto.aula05.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataVenda;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> itensVenda = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @Transient
    private String tipoPessoa;

    public Venda() {}

    public Venda(Long id, LocalDateTime dataVenda) {
        this.id = id;
        this.dataVenda = dataVenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Double totalVenda() {
        return itensVenda.stream().mapToDouble(item -> item.totalItem().doubleValue()).sum();

//        double total = 0.0;
//        for (ItemVenda itemVenda : itensVenda) {
//            total += itemVenda.totalItem().doubleValue();
//        }
//        return total;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }
}
