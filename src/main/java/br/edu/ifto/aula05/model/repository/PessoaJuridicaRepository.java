package br.edu.ifto.aula05.model.repository;

import br.edu.ifto.aula05.model.entity.PessoaFisica;
import br.edu.ifto.aula05.model.entity.PessoaJuridica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PessoaJuridicaRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void save(PessoaJuridica pessoaJuridica) {
        if (pessoaJuridica.getId() == null) {
            em.persist(pessoaJuridica);
        } else {
            em.merge(pessoaJuridica);
        }
    }

    public PessoaJuridica findById(Long id) {
        return em.find(PessoaJuridica.class, id);
    }

    public List<PessoaJuridica> findAll() {
        Query query = em.createQuery("from PessoaJuridica");
        return query.getResultList();
    }

    @Transactional
    public void deleteById(Long id) {
        PessoaJuridica pessoaJuridica = em.find(PessoaJuridica.class, id);
        em.remove(pessoaJuridica);
    }
}

