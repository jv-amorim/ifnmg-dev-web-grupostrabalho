package jvamorim.grupostrabalho.beans;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import jvamorim.grupostrabalho.models.entities.Atuacao;

public class AtuacaoBean implements AtuacaoBeanLocal {

    @PersistenceContext(unitName = "GruposTrabalhoPU")
    private EntityManager entityManager;
    
    @Override
    public void save(Atuacao atuacao) {
        entityManager.persist(atuacao);
    }

    @Override
    public List<Object[]> findAllByMembroNome(String membroNome) {
        TypedQuery q = entityManager.createNamedQuery("Atuacao.findAllByMembroNome", Object[].class);
        q.setParameter("membroNome", membroNome);
        return q.getResultList();
    }
    
}
