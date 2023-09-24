package jvamorim.grupostrabalho.beans;

import java.util.List;
import jvamorim.grupostrabalho.models.entities.Grupo;

public interface GrupoBeanLocal {
    
    void save(Grupo grupo);

    List<Grupo> findAllInativo();

    public List<Object[]> findAllNomeLider();

    public List<String> findAllMembroNomeDescByNomeGrupo(String nomeGrupo);

    public List<Grupo> findAllByLider(String nomeLider);

    public List<Grupo> findAllByNameLike(String nomeGrupo);

    public List<Object[]> findAllMembroCount();

    public List<Object[]> findAllMembroCountWithMinimum(Long min);
    
}
