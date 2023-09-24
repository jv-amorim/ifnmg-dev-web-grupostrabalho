package jvamorim.grupostrabalho.beans;

import java.util.List;
import jvamorim.grupostrabalho.models.entities.Pessoa;

public interface PessoaBeanLocal {
    
    void save(Pessoa pessoa);
    
    List<Pessoa> findAll_Query();
    
    List<Pessoa> findAll_TypedQuery();
    
    List<Pessoa> findAll_NamedQuery();
    
    List<String> findAllNome_Query();
    
    List<String> findAllNome_TypedQuery();
    
    List<String> findAllNome_NamedQuery();
    
    List<Pessoa> findAllNomeEndereco_Query();
    
    List<Pessoa> findAllNomeEndereco_TypedQuery();
    
    List<Pessoa> findAllNomeEndereco_NamedQuery();
    
}
