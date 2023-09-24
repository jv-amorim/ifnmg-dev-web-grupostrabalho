package jvamorim.grupostrabalho.beans;

import java.time.LocalDate;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jvamorim.grupostrabalho.models.entities.Endereco;
import jvamorim.grupostrabalho.models.entities.Grupo;
import jvamorim.grupostrabalho.models.entities.Pessoa;
import jvamorim.grupostrabalho.models.entities.Telefone;
import jvamorim.grupostrabalho.models.enums.TipoLogradouro;

@Singleton
@Startup
public class CargaDadosBean implements CargaDadosBeanLocal {
    
    @PersistenceContext(unitName = "GruposTrabalhoPU")
    private EntityManager entityManager;
    
    @PostConstruct
    @Override
    public void popularBanco() {
        
        // Endereços:
        
        Endereco enderecoAna = new Endereco();
        enderecoAna.setTipoLogradouro(TipoLogradouro.RUA);
        enderecoAna.setLogradouro("1");
        enderecoAna.setNumero(1111);
        enderecoAna.setBairro("Humberto");
        
        Endereco enderecoBeatriz = new Endereco();
        enderecoBeatriz.setTipoLogradouro(TipoLogradouro.AVENIDA);
        enderecoBeatriz.setLogradouro("2");
        enderecoBeatriz.setNumero(2222);
        enderecoBeatriz.setBairro("Doisberto");
        
        Endereco enderecoCecilia = new Endereco();
        enderecoCecilia.setTipoLogradouro(TipoLogradouro.AVENIDA);
        enderecoCecilia.setLogradouro("3");
        enderecoCecilia.setNumero(3333);
        enderecoCecilia.setBairro("Trêsberto");
        
        Endereco enderecoDebora = new Endereco();
        enderecoDebora.setTipoLogradouro(TipoLogradouro.PRACA);
        enderecoDebora.setLogradouro("4");
        enderecoDebora.setNumero(4444);
        enderecoDebora.setBairro("Quatroberto");
        
        
        // Telefones:
        
        Telefone telefoneAna1 = new Telefone();
        telefoneAna1.setDdd(((Integer)11).byteValue());
        telefoneAna1.setNumero(11111111);
        
        Telefone telefoneAna2 = new Telefone();
        telefoneAna2.setDdd(((Integer)12).byteValue());
        telefoneAna2.setNumero(12121212);
        
        Telefone telefoneAna3 = new Telefone();
        telefoneAna3.setDdd(((Integer)13).byteValue());
        telefoneAna3.setNumero(13131313);
        
        Telefone telefoneBeatriz1 = new Telefone();
        telefoneBeatriz1.setDdd(((Integer)22).byteValue());
        telefoneBeatriz1.setNumero(22222222);
        
        Telefone telefoneDebora1 = new Telefone();
        telefoneDebora1.setDdd(((Integer)44).byteValue());
        telefoneDebora1.setNumero(44444444);
        
        Telefone telefoneDebora2 = new Telefone();
        telefoneDebora2.setDdd(((Integer)45).byteValue());
        telefoneDebora2.setNumero(45454545);
        
        
        // Pessoas:
        
        Pessoa pessoaAna = new Pessoa();
        pessoaAna.setNome("Ana Zaira");
        pessoaAna.setEmail("ana@mail.com");
        pessoaAna.setNascimento(LocalDate.of(2001, 01, 01));
        pessoaAna.setEndereco(enderecoAna);
        pessoaAna.getTelefones().add(telefoneAna1);
        pessoaAna.getTelefones().add(telefoneAna2);
        pessoaAna.getTelefones().add(telefoneAna3);
        telefoneAna1.setPessoa(pessoaAna);
        telefoneAna2.setPessoa(pessoaAna);
        telefoneAna3.setPessoa(pessoaAna);
        
        Pessoa pessoaBeatriz = new Pessoa();
        pessoaBeatriz.setNome("Beatriz Yana");
        pessoaBeatriz.setEmail("beatriz@mail.com");
        pessoaBeatriz.setNascimento(LocalDate.of(2002, 02, 02));
        pessoaBeatriz.setEndereco(enderecoBeatriz);
        pessoaBeatriz.getTelefones().add(telefoneBeatriz1);
        telefoneBeatriz1.setPessoa(pessoaBeatriz);
        
        Pessoa pessoaCecilia = new Pessoa();
        pessoaCecilia.setNome("Cecília Xerxes");
        pessoaCecilia.setEmail("cecilia@mail.com");
        pessoaCecilia.setNascimento(LocalDate.of(2003, 03, 03));
        pessoaCecilia.setEndereco(enderecoCecilia);
        
        Pessoa pessoaDebora = new Pessoa();
        pessoaDebora.setNome("Débora Wendel");
        pessoaDebora.setEmail("debora@mail.com");
        pessoaDebora.setNascimento(LocalDate.of(2004, 04, 04));
        pessoaDebora.setEndereco(enderecoDebora);
        pessoaDebora.getTelefones().add(telefoneDebora1);
        pessoaDebora.getTelefones().add(telefoneDebora2);
        telefoneDebora1.setPessoa(pessoaDebora);
        telefoneDebora2.setPessoa(pessoaDebora);
        
        
        // Grupos:
        
        Grupo grupo1 = new Grupo();
        grupo1.setNome("Estudo I");
        grupo1.setAtivo(false);
        grupo1.setLider(pessoaAna);
        pessoaAna.getGruposLiderados().add(grupo1);
        
        Grupo grupo2 = new Grupo();
        grupo2.setNome("Estudo II");
        grupo2.setAtivo(true);
        grupo2.setLider(pessoaBeatriz);
        pessoaBeatriz.getGruposLiderados().add(grupo2);
        
        Grupo grupo3 = new Grupo();
        grupo3.setNome("Estudo III");
        grupo3.setAtivo(false);
        grupo3.setLider(pessoaCecilia);
        pessoaCecilia.getGruposLiderados().add(grupo3);
        
        Grupo grupo4 = new Grupo();
        grupo4.setNome("Estudo IV");
        grupo4.setAtivo(true);
        grupo4.setLider(pessoaBeatriz);
        pessoaBeatriz.getGruposLiderados().add(grupo4);
               
        
        // Persist:
        
        entityManager.persist(enderecoAna);
        entityManager.persist(enderecoBeatriz);
        entityManager.persist(enderecoCecilia);
        entityManager.persist(enderecoDebora);
        
        entityManager.persist(pessoaAna);
        entityManager.persist(pessoaBeatriz);
        entityManager.persist(pessoaCecilia);
        entityManager.persist(pessoaDebora);
        
        entityManager.persist(telefoneAna1);
        entityManager.persist(telefoneAna2);
        entityManager.persist(telefoneAna3);
        entityManager.persist(telefoneBeatriz1);
        entityManager.persist(telefoneDebora1);
        entityManager.persist(telefoneDebora2);
        
        entityManager.persist(grupo1);
        entityManager.persist(grupo2);
        entityManager.persist(grupo3);
        entityManager.persist(grupo4);
        
        entityManager.flush();
    }
    
}
