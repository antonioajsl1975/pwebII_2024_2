package br.edu.ifto.aula04.model.repository;

import br.edu.ifto.aula04.model.entity.Produto;
import br.edu.ifto.aula04.model.entity.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VendaRepository {

    @PersistenceContext
    private EntityManager em;

    public Venda venda(Long id) {
        return em.find(Venda.class, id);
    }

    @Transactional
    public void save(Venda venda) {
        em.persist(venda);
    }

    public Venda findById(Long id) {
        return em.find(Venda.class, id);
    }

    @Transactional
    public void remove(Long id) {
        Venda venda = em.find(Venda.class, id);
        em.remove(venda);
    }

    @Transactional
    public void update(Venda Venda) {
        em.merge(Venda);
    }

    public List<Venda> vendas() {
        Query query = em.createQuery("from Venda");
        return query.getResultList();
    }
}
