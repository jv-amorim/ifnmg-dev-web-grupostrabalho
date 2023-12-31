package jvamorim.grupostrabalho.beans;

import java.time.LocalDate;
import java.util.List;
import jvamorim.grupostrabalho.models.dtos.MembroDto;
import jvamorim.grupostrabalho.models.entities.Atuacao;

public interface AtuacaoBeanLocal {
    
    void save(Atuacao atuacao);

    public List<Object[]> findAllByMembroNome(String membroNome);

    public List<String> findAllMembroNomeByGrupoIdAndMinimumDate(Long grupoId, LocalDate minDate);

    public List<MembroDto> findAllMembroDtoByGrupoIdAndMinimumDate(Long grupoId, LocalDate minDate);

    public List<Object[]> findAllGruposWithoutTermino();
    
}
