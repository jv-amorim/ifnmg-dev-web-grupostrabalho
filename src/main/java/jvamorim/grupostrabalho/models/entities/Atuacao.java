package jvamorim.grupostrabalho.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "atuacao")

@NamedQueries({
    @NamedQuery(
        name = "Atuacao.findAllByMembroNome",
        query = "SELECT a.grupo.nome, a.inicio, a.termino "
              + "FROM Atuacao a "
              + "WHERE a.pessoa.nome = :membroNome"
    ),
    @NamedQuery(
        name = "Atuacao.findAllMembroNomeByGrupoIdAndMinimumDate",
        query = "SELECT DISTINCT a.pessoa.nome "
              + "FROM Atuacao a "
              + "WHERE (a.grupo.id = :grupoId OR :grupoId IS NULL) AND a.inicio >= :minDate"
    ),
    @NamedQuery(
        name = "Atuacao.findAllMembroDtoByGrupoIdAndMinimumDate",
        query = "SELECT new jvamorim.grupostrabalho.models.dtos.MembroDto(a.grupo.nome, a.pessoa.nome, a.inicio) "
              + "FROM Atuacao a "
              + "WHERE (a.grupo.id = :grupoId OR :grupoId IS NULL) AND a.inicio >= :minDate "
              + "ORDER BY a.grupo.nome, a.inicio"
    ),
    @NamedQuery(
        name = "Atuacao.findAllGruposWithoutTermino",
        query = "SELECT a.grupo.nome, a.pessoa.nome "
              + "FROM Atuacao a "
              + "WHERE a.termino IS NULL"
    ),
})
public class Atuacao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoaid", nullable = false)
    @JsonbTransient
    private Pessoa pessoa;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "grupoid", nullable = false)
    @JsonbTransient
    private Grupo grupo;
    
    @Column(nullable = false)
    private LocalDate inicio;
    
    @Column(nullable = true)
    private LocalDate termino;
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
