package jvamorim.grupostrabalho.beans;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import jvamorim.grupostrabalho.models.entities.Grupo;

public class GrupoBean implements GrupoBeanLocal {

    @PersistenceContext(unitName = "GruposTrabalhoPU")
    private EntityManager entityManager;
    
    @Override
    public void save(Grupo grupo) {
        entityManager.persist(grupo);
    }

    @Override
    public List<Grupo> findAllInativo() {
        TypedQuery q = entityManager.createNamedQuery("Grupo.findAllInativo", Grupo.class);
        return q.getResultList();
    }

    @Override
    public List<Object[]> findAllNomeLider() {
        TypedQuery q = entityManager.createNamedQuery("Grupo.findAllNomeLider", Object[].class);
        return q.getResultList();
    }

    @Override
    public List<String> findAllMembroNomeDescByNomeGrupo(String nomeGrupo) {
        TypedQuery q = entityManager.createNamedQuery("Grupo.findAllMembroNomeDescByNomeGrupo", String.class);
        q.setParameter("nomeGrupo", nomeGrupo);
        return q.getResultList();
    }

    @Override
    public List<Grupo> findAllByLider(String nomeLider) {
        TypedQuery q = entityManager.createNamedQuery("Grupo.findAllByLider", Grupo.class);
        q.setParameter("nomeLider", nomeLider);
        return q.getResultList();
    }
    
}
