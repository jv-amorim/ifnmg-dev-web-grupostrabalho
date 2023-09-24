package jvamorim.grupostrabalho.beans;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jvamorim.grupostrabalho.models.entities.Pessoa;

public class PessoaBean implements PessoaBeanLocal {

    @PersistenceContext(unitName = "GruposTrabalhoPU")
    private EntityManager entityManager;
    
    @Override
    public void save(Pessoa pessoa) {
        entityManager.persist(pessoa);
    }
    
}
