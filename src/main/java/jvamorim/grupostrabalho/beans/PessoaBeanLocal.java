package jvamorim.grupostrabalho.beans;

import java.util.List;
import jvamorim.grupostrabalho.models.entities.Pessoa;

public interface PessoaBeanLocal {
    
    void save(Pessoa pessoa);
    
    List<Pessoa> findAll_Query();
    
    List<Pessoa> findAll_TypedQuery();
    
    List<Pessoa> findAll_NamedQuery();
    
}
