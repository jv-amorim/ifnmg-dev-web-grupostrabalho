package jvamorim.grupostrabalho.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
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
    
    //</editor-fold>
    
}
