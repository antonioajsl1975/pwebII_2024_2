package br.edu.ifto.aula05.model.repository;

import br.edu.ifto.aula05.model.entity.Pessoa;
import br.edu.ifto.aula05.model.entity.Produto;
import br.edu.ifto.aula05.model.entity.Venda;
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
        if (pessoa.getId() == null) {
            em.persist(pessoa);  // Persistir nova pessoa
        } else {
            em.merge(pessoa);  // Atualizar pessoa existente
        }
    }

    public List<Pessoa> findAll() {
        return em.createQuery("SELECT p FROM Pessoa p", Pessoa.class)
                .getResultList();
    }

    public Pessoa findById(Long id) {
        return em.find(Pessoa.class, id);
    }

    @Transactional
    public void update(Pessoa pessoa) {
        em.merge(pessoa);
    }

    @Transactional
    public void remove(Long id) {
        Pessoa pessoa = em.find(Pessoa.class, id);
        em.remove(pessoa);
    }
}
