package br.edu.ifto.aula04.model.repository;

import br.edu.ifto.aula04.model.entity.ItemVenda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemVendaRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(ItemVenda itemVenda) {
        em.merge(itemVenda);
    }

    public ItemVenda itemVenda(Long id) {
        return em.find(ItemVenda.class, id);
    }

    public List<ItemVenda> itensVenda() {
        Query query = em.createQuery("from ItemVenda");
        return query.getResultList();
    }

    @Transactional
    public void remove(Long id) {
        ItemVenda itemVenda = em.find(ItemVenda.class, id);
        em.remove(itemVenda);
    }

    @Transactional
    public void update(ItemVenda itemVenda) {
        em.merge(itemVenda);
    }
}
