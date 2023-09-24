package jvamorim.grupostrabalho.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Atuacao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private AtuacaoKey id;
    
    @ManyToOne
    @MapsId("pessoaId")
    @JoinColumn(name = "pessoaid", nullable = false)
    private Pessoa pessoa;
    
    @ManyToOne
    @MapsId("grupoId")
    @JoinColumn(name = "grupoid", nullable = false)
    private Grupo grupo;
    
    @Column(nullable = false)
    private LocalDate inicio;
    
    @Column(nullable = true)
    private LocalDate termino;
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    
    public Atuacao() {
        id = new AtuacaoKey();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    public AtuacaoKey getId() {
        return id;
    }

    public void setId(AtuacaoKey id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getTermino() {
        return termino;
    }

    public void setTermino(LocalDate termino) {
        this.termino = termino;
    }
    
    //</editor-fold>
    
}
