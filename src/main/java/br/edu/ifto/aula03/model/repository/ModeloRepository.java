package br.edu.ifto.aula03.model.repository;

import br.edu.ifto.aula03.model.entity.Marca;
import br.edu.ifto.aula03.model.entity.Modelo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ModeloRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Modelo modelo) {
        em.merge(modelo);
    }

    public Modelo modelo(Long id) {
        return em.find(Modelo.class, id);
    }

    public List<Modelo> modelos() {
        Query query = em.createQuery("from Modelo");
        return query.getResultList();
    }

    @Transactional
    public void remove(Long id) {
        Modelo modelo = em.find(Modelo.class, id);
        em.remove(modelo);
    }
    @Transactional
    public void update(Modelo modelo) {
        em.merge(modelo);
    }
}
