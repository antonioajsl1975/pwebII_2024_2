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

    // Método para buscar veículos com paginação
    public List<Veiculo> veiculos(int page, int size) {
        Query query = em.createQuery("from Veiculo");
        query.setFirstResult(page * size);  // Define o "offset"
        query.setMaxResults(size);  // Define o número de resultados por página
        return query.getResultList();
    }

    // Metodo para contar o número total de veículos
    public long count() {
        Query query = em.createQuery("SELECT COUNT(v) FROM Veiculo v");
        return (long) query.getSingleResult();
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

