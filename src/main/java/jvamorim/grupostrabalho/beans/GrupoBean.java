package jvamorim.grupostrabalho.beans;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jvamorim.grupostrabalho.models.entities.Grupo;

public class GrupoBean implements GrupoBeanLocal {

    @PersistenceContext(unitName = "GruposTrabalhoPU")
    private EntityManager entityManager;
    
    @Override
    public void save(Grupo grupo) {
        entityManager.persist(grupo);
    }
    
}
