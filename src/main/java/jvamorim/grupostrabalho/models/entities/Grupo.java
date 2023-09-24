package jvamorim.grupostrabalho.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grupo")
@NamedQueries({
    @NamedQuery(
        name = "Grupo.findAllInativo",
        query = "SELECT g "
              + "FROM Grupo g "
              + "WHERE g.ativo = false"
    ),
    @NamedQuery(
        name = "Grupo.findAllNomeLider",
        query = "SELECT g.nome, g.lider.nome "
              + "FROM Grupo g"
    ),
    @NamedQuery(
        name = "Grupo.findAllMembroNomeDescByNomeGrupo",
        query = "SELECT DISTINCT a.pessoa.nome "
              + "FROM Grupo g, IN (g.atuacoes) a "
              + "WHERE g.nome = :nomeGrupo "
              + "ORDER BY a.pessoa.nome DESC"
    ),
    @NamedQuery(
        name = "Grupo.findAllByLider",
        query = "SELECT g "
              + "FROM Grupo g "
              + "WHERE g.lider.nome = :nomeLider "
    ),
})
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 65, nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private Boolean ativo;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "liderid", nullable = false)
    @JsonbTransient
    private Pessoa lider;
    
    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atuacao> atuacoes;
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    
    public Grupo() {
        atuacoes = new ArrayList<Atuacao>();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Pessoa getLider() {
        return lider;
    }

    public void setLider(Pessoa lider) {
        this.lider = lider;
    }
    
    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    public void setAtuacoes(List<Atuacao> atuacoes) {
        this.atuacoes = atuacoes;
    }
    
    //</editor-fold>
    
}
