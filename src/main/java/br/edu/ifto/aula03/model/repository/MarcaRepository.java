package br.edu.ifto.aula03.model.repository;

import br.edu.ifto.aula03.model.entity.Marca;
import br.edu.ifto.aula03.model.entity.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MarcaRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Marca marca) {
        em.merge(marca);
    }

    public Marca marca(Long id) {
        return em.find(Marca.class, id);
    }

    public List<Marca> marcas() {
        Query query = em.createQuery("from Marca");
        return query.getResultList();
    }

    @Transactional
    public void remove(Long id) {
        Marca marca = em.find(Marca.class, id);
        em.remove(marca);
    }

    public void update(Marca marca) {
        em.merge(marca);
    }
}
