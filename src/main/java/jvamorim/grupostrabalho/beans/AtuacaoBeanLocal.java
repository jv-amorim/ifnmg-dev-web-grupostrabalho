package jvamorim.grupostrabalho.beans;

import java.util.List;
import jvamorim.grupostrabalho.models.entities.Atuacao;

public interface AtuacaoBeanLocal {
    
    void save(Atuacao atuacao);

    public List<Object[]> findAllByMembroNome(String membroNome);
    
}
