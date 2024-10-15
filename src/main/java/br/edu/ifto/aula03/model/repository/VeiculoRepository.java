package br.edu.ifto.aula03.model.repository;

import br.edu.ifto.aula03.model.entity.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VeiculoRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Veiculo veiculo) {
        em.merge(veiculo);
    }

    public Veiculo veiculo(Long id) {
        return em.find(Veiculo.class, id);
    }

    public List<Veiculo> veiculos() {
        Query query = em.createQuery("from Veiculo");
        return query.getResultList();
    }

    @Transactional
    public void remove(Long id) {
        Veiculo veiculo = em.find(Veiculo.class, id);
        em.remove(veiculo);
    }

    public void update(Veiculo veiculo) {
        em.merge(veiculo);
    }
}
