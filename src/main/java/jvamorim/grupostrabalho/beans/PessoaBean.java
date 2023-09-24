package jvamorim.grupostrabalho.beans;

import java.time.LocalDate;
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
    public List<Object[]> findAllNomeEndereco_Query() {
        Query q = entityManager.createQuery("SELECT p.nome, p.endereco FROM Pessoa p");
        return (List<Object[]>) q.getResultList();
    }

    @Override
    public List<Object[]> findAllNomeEndereco_TypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p.nome, p.endereco FROM Pessoa p", Object[].class);
        return q.getResultList();
    }

    @Override
    public List<Object[]> findAllNomeEndereco_NamedQuery() {
        TypedQuery q = entityManager.createNamedQuery("Pessoa.findAllNomeEndereco", Object[].class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> findAllInAvenida_Query() {
        Query q = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro = 1");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> findAllInAvenida_TypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro = 1", Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> findAllInAvenida_NamedQuery() {
        TypedQuery q = entityManager.createNamedQuery("Pessoa.findAllInAvenida", Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> findAllNotInPraca_Query() {
        Query q = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro != 2");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> findAllNotInPraca_TypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro != 2", Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> findAllNotInPraca_NamedQuery() {
        TypedQuery q = entityManager.createNamedQuery("Pessoa.findAllNotInPraca", Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Object[]> findAllNomeTelefone_Query() {
        Query q = entityManager.createQuery("SELECT p.nome, t FROM Pessoa p, IN (p.telefones) t");
        return (List<Object[]>) q.getResultList();
    }

    @Override
    public List<Object[]> findAllNomeTelefone_TypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p.nome, t FROM Pessoa p, IN (p.telefones) t", Object[].class);
        return q.getResultList();
    }

    @Override
    public List<Object[]> findAllNomeTelefone_NamedQuery() {
        TypedQuery q = entityManager.createNamedQuery("Pessoa.findAllNomeTelefone", Object[].class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> findAllInNascimentoInterval(LocalDate dataInicial, LocalDate dataFinal) {
        TypedQuery q = entityManager.createNamedQuery("Pessoa.findAllInNascimentoInterval", Pessoa.class);
        q.setParameter("dataInicial", dataInicial);
        q.setParameter("dataFinal", dataFinal);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> findAllByTelefonePrefixo(String prefixo) {
        TypedQuery q = entityManager.createNamedQuery("Pessoa.findAllByTelefonePrefixo", Pessoa.class);
        q.setParameter("prefixo", prefixo);
        return q.getResultList();
    }
    
}
