package jvamorim.grupostrabalho.models.dtos;

import java.time.LocalDate;

public class MembroDto {
    
    private String nomeGrupo;
    private String membroGrupo;
    private LocalDate dataEntrada;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    
    public MembroDto() {
    }

    public MembroDto(String nomeGrupo, String membroGrupo, LocalDate dataEntrada) {
        this.nomeGrupo = nomeGrupo;
        this.membroGrupo = membroGrupo;
        this.dataEntrada = dataEntrada;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public String getMembroGrupo() {
        return membroGrupo;
    }

    public void setMembroGrupo(String membroGrupo) {
        this.membroGrupo = membroGrupo;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    
    //</editor-fold>
    
}
