package jvamorim.grupostrabalho.beans;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jvamorim.grupostrabalho.models.entities.Telefone;

public class TelefoneBean implements TelefoneBeanLocal {

    @PersistenceContext(unitName = "GruposTrabalhoPU")
    private EntityManager entityManager;
    
    @Override
    public void save(Telefone telefone) {
        entityManager.persist(telefone);
    }
    
}
