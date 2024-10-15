package br.edu.ifto.aula03.model.repository;

import br.edu.ifto.aula03.model.entity.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PessoaRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Pessoa pessoa) {
        em.merge(pessoa);
    }

    public Pessoa pessoa(Long id) {
        return em.find(Pessoa.class, id);
    }

    public List<Pessoa> pessoas() {
        Query query = em.createQuery("from Pessoa");
        return query.getResultList();
    }

    @Transactional
    public void remove(Long id) {
        Pessoa pessoa = em.find(Pessoa.class, id);
        em.remove(pessoa);
    }

    public void update(Pessoa pessoa) {
        em.merge(pessoa);
    }
}
