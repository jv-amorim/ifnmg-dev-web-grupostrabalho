package jvamorim.grupostrabalho.beans;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jvamorim.grupostrabalho.models.entities.Atuacao;

public class AtuacaoBean implements AtuacaoBeanLocal {

    @PersistenceContext(unitName = "GruposTrabalhoPU")
    private EntityManager entityManager;
    
    @Override
    public void save(Atuacao atuacao) {
        entityManager.persist(atuacao);
    }
    
}
