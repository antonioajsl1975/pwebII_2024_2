package br.edu.ifto.aula03.model.repository;

import br.edu.ifto.aula03.model.entity.Veiculo;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
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

    // Método para buscar todos os veículos
    public List<Veiculo> findAll() {
        Query query = em.createQuery("FROM Veiculo");
        return query.getResultList(); // Retorna todos os resultados
    }

    @Transactional
    public void remove(Long id) {
        Veiculo veiculo = em.find(Veiculo.class, id);
        em.remove(veiculo);
    }

    @Transactional
    public void update(Veiculo veiculo) {
        em.merge(veiculo);
    }
}


