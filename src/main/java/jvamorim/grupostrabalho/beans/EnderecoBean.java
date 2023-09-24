package jvamorim.grupostrabalho.beans;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jvamorim.grupostrabalho.models.entities.Endereco;

public class EnderecoBean implements EnderecoBeanLocal {

    @PersistenceContext(unitName = "GruposTrabalhoPU")
    private EntityManager entityManager;
    
    @Override
    public void save(Endereco endereco) {
        entityManager.persist(endereco);
    }
    
}
