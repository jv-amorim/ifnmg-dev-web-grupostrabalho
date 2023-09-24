package jvamorim.grupostrabalho.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "pessoa")
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")
})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 65, nullable = false)
    private String nome;
    
    @Column(length = 250, nullable = false)
    private String email;
    
    @Column(nullable = false)
    private LocalDate nascimento;
    
    @Transient
    private Byte idade;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "enderecoid")
    private Endereco endereco;
    
    @OneToMany(mappedBy = "pessoa")
    private List<Telefone> telefones;
    
    @OneToMany(mappedBy = "lider")
    private List<Grupo> gruposLiderados;
    
    @OneToMany(mappedBy = "pessoa")
    private List<Atuacao> atuacoes;
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    
    public Pessoa() {
        telefones = new ArrayList<Telefone>();
        gruposLiderados = new ArrayList<Grupo>();
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Byte getIdade() {
        return (byte)YEARS.between(nascimento, LocalDate.now());
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Grupo> getGruposLiderados() {
        return gruposLiderados;
    }

    public void setGruposLiderados(List<Grupo> gruposLiderados) {
        this.gruposLiderados = gruposLiderados;
    }

    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    public void setAtuacoes(List<Atuacao> atuacoes) {
        this.atuacoes = atuacoes;
    }
    
    //</editor-fold>
    
}
