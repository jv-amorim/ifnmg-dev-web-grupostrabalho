package jvamorim.grupostrabalho.beans;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import jvamorim.grupostrabalho.models.entities.Pessoa;

public class PessoaBean implements PessoaBeanLocal {

    @PersistenceContext(unitName = "GruposTrabalhoPU")
    private EntityManager entityManager;
    
    @Override
    public void save(Pessoa pessoa) {
        entityManager.persist(pessoa);
    }

    @Override
    public List<Pessoa> findAll_Query() {
        Query q = entityManager.createQuery("SELECT p FROM Pessoa p");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> findAll_TypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> findAll_NamedQuery() {
        TypedQuery q = entityManager.createNamedQuery("Pessoa.findAll", Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<String> findAllNome_Query() {
        Query q = entityManager.createQuery("SELECT p.nome FROM Pessoa p");
        return (List<String>) q.getResultList();
    }

    @Override
    public List<String> findAllNome_TypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p.nome FROM Pessoa p", String.class);
        return q.getResultList();
    }

    @Override
    public List<String> findAllNome_NamedQuery() {
        TypedQuery q = entityManager.createNamedQuery("Pessoa.findAllNome", String.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> findAllNomeEndereco_Query() {
        Query q = entityManager.createQuery("SELECT p.nome, p.endereco FROM Pessoa p");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> findAllNomeEndereco_TypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p.nome, p.endereco FROM Pessoa p", Object[].class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> findAllNomeEndereco_NamedQuery() {
        TypedQuery q = entityManager.createNamedQuery("Pessoa.findAllNomeEndereco", Object[].class);
        return q.getResultList();
    }
    
}
