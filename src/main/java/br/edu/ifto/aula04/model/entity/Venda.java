package br.edu.ifto.aula04.model.entity;

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

    public List<ItemVenda> getItens() {
        return itensVenda;
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
