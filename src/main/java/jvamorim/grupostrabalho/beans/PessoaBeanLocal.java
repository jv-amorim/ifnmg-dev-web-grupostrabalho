package jvamorim.grupostrabalho.beans;

import java.time.LocalDate;
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
    
    List<Object[]> findAllNomeEndereco_Query();
    
    List<Object[]> findAllNomeEndereco_TypedQuery();
    
    List<Object[]> findAllNomeEndereco_NamedQuery();
    
    List<Pessoa> findAllInAvenida_Query();
    
    List<Pessoa> findAllInAvenida_TypedQuery();
    
    List<Pessoa> findAllInAvenida_NamedQuery();
    
    List<Pessoa> findAllNotInPraca_Query();
    
    List<Pessoa> findAllNotInPraca_TypedQuery();
    
    List<Pessoa> findAllNotInPraca_NamedQuery();
    
    List<Object[]> findAllNomeTelefone_Query();
    
    List<Object[]> findAllNomeTelefone_TypedQuery();
    
    List<Object[]> findAllNomeTelefone_NamedQuery();
    
    List<Pessoa> findAllInNascimentoInterval(LocalDate dataInicial, LocalDate dataFinal);

    List<Pessoa> findAllByTelefonePrefixo(String prefixo);

    List<Pessoa> findAllWithoutTelefone();
    
    List<Object[]> findAllTelefoneCount();
    
}
