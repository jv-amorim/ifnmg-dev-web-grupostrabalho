package jvamorim.grupostrabalho.beans;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import jvamorim.grupostrabalho.models.dtos.MembroDto;
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

    @Override
    public List<String> findAllMembroNomeByGrupoIdAndMinimumDate(Long grupoId, LocalDate minDate) {
        TypedQuery q = entityManager.createNamedQuery("Atuacao.findAllMembroNomeByGrupoIdAndMinimumDate", String.class);
        q.setParameter("grupoId", grupoId);
        q.setParameter("minDate", minDate);
        return q.getResultList();
        
    }

    @Override
    public List<MembroDto> findAllMembroDtoByGrupoIdAndMinimumDate(Long grupoId, LocalDate minDate) {
        TypedQuery q = entityManager.createNamedQuery("Atuacao.findAllMembroDtoByGrupoIdAndMinimumDate", MembroDto.class);
        q.setParameter("grupoId", grupoId);
        q.setParameter("minDate", minDate);
        return q.getResultList();
    }

    @Override
    public List<Object[]> findAllGruposWithoutTermino() {
        TypedQuery q = entityManager.createNamedQuery("Atuacao.findAllGruposWithoutTermino", Object[].class);
        return q.getResultList();
    }
    
}
