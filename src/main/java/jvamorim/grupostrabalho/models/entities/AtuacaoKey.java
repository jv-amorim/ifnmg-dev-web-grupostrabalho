package jvamorim.grupostrabalho.models.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class AtuacaoKey implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long pessoaId;
    
    private Long grupoId;
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }
    
    //</editor-fold>

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessoaId != null ? pessoaId.hashCode() : 0);
        hash += (grupoId != null ? grupoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AtuacaoKey)) {
            return false;
        }
        AtuacaoKey other = (AtuacaoKey) object;
        if ((this.pessoaId == null && other.pessoaId != null) || (this.pessoaId != null && !this.pessoaId.equals(other.pessoaId))) {
            return false;
        }
        if ((this.grupoId == null && other.grupoId != null) || (this.grupoId != null && !this.grupoId.equals(other.grupoId))) {
            return false;
        }
        return true;
    }
    
}
