package jvamorim.grupostrabalho.beans;

import java.time.LocalDate;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import jvamorim.grupostrabalho.models.entities.Atuacao;
import jvamorim.grupostrabalho.models.entities.Endereco;
import jvamorim.grupostrabalho.models.entities.Grupo;
import jvamorim.grupostrabalho.models.entities.Pessoa;
import jvamorim.grupostrabalho.models.entities.Telefone;
import jvamorim.grupostrabalho.models.enums.TipoLogradouro;

@Singleton
@Startup
public class CargaDadosBean implements CargaDadosBeanLocal {
    
    @Inject private PessoaBeanLocal pessoaBean;
    
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
        
        
        // Atuações:
        
        Atuacao atuacao1 = new Atuacao();
        atuacao1.setGrupo(grupo1);
        atuacao1.setPessoa(pessoaAna);
        atuacao1.setInicio(LocalDate.of(2011, 01, 01));
        atuacao1.setTermino(LocalDate.of(2021, 11, 11));
        grupo1.getAtuacoes().add(atuacao1);
        pessoaAna.getAtuacoes().add(atuacao1);
        
        Atuacao atuacao2 = new Atuacao();
        atuacao1.setGrupo(grupo1);
        atuacao1.setPessoa(pessoaAna);
        atuacao1.setInicio(LocalDate.of(2012, 01, 01));
        atuacao1.setTermino(LocalDate.of(2022, 11, 11));
        grupo1.getAtuacoes().add(atuacao1);
        pessoaAna.getAtuacoes().add(atuacao1);
        
        Atuacao atuacao3 = new Atuacao();
        atuacao2.setGrupo(grupo1);
        atuacao2.setPessoa(pessoaBeatriz);
        atuacao2.setInicio(LocalDate.of(2012, 01, 02));
        atuacao2.setTermino(LocalDate.of(2021, 01, 12));
        grupo1.getAtuacoes().add(atuacao2);
        pessoaBeatriz.getAtuacoes().add(atuacao2);
        
        Atuacao atuacao4 = new Atuacao();
        atuacao3.setGrupo(grupo1);
        atuacao3.setPessoa(pessoaCecilia);
        atuacao3.setInicio(LocalDate.of(2013, 01, 03));
        atuacao3.setTermino(LocalDate.of(2021, 01, 13));
        grupo1.getAtuacoes().add(atuacao3);
        pessoaCecilia.getAtuacoes().add(atuacao3);
        
        Atuacao atuacao5 = new Atuacao();
        atuacao4.setGrupo(grupo1);
        atuacao4.setPessoa(pessoaDebora);
        atuacao4.setInicio(LocalDate.of(2014, 01, 04));
        atuacao4.setTermino(LocalDate.of(2021, 01, 14));
        grupo1.getAtuacoes().add(atuacao4);
        pessoaDebora.getAtuacoes().add(atuacao4);
        
        Atuacao atuacao6 = new Atuacao();
        atuacao5.setGrupo(grupo2);
        atuacao5.setPessoa(pessoaBeatriz);
        atuacao5.setInicio(LocalDate.of(2012, 01, 02));
        grupo2.getAtuacoes().add(atuacao5);
        pessoaBeatriz.getAtuacoes().add(atuacao5);
        
        Atuacao atuacao7 = new Atuacao();
        atuacao6.setGrupo(grupo2);
        atuacao6.setPessoa(pessoaDebora);
        atuacao6.setInicio(LocalDate.of(2012, 01, 02));
        grupo2.getAtuacoes().add(atuacao6);
        pessoaDebora.getAtuacoes().add(atuacao6);
        
        Atuacao atuacao8 = new Atuacao();
        atuacao7.setGrupo(grupo3);
        atuacao7.setPessoa(pessoaCecilia);
        atuacao7.setInicio(LocalDate.of(2012, 01, 03));
        atuacao7.setTermino(LocalDate.of(2023, 01, 13));
        grupo3.getAtuacoes().add(atuacao7);
        pessoaCecilia.getAtuacoes().add(atuacao7);
        
        Atuacao atuacao9 = new Atuacao();
        atuacao8.setGrupo(grupo3);
        atuacao8.setPessoa(pessoaDebora);
        atuacao8.setInicio(LocalDate.of(2012, 01, 03));
        atuacao8.setTermino(LocalDate.of(2023, 01, 13));
        grupo3.getAtuacoes().add(atuacao8);
        pessoaDebora.getAtuacoes().add(atuacao8);
        
        Atuacao atuacao10 = new Atuacao();
        atuacao9.setGrupo(grupo4);
        atuacao9.setPessoa(pessoaBeatriz);
        atuacao9.setInicio(LocalDate.of(2012, 01, 04));
        atuacao9.setTermino(LocalDate.of(2024, 01, 14));
        grupo4.getAtuacoes().add(atuacao9);
        pessoaBeatriz.getAtuacoes().add(atuacao9);
        
        Atuacao atuacao11 = new Atuacao();
        atuacao10.setGrupo(grupo4);
        atuacao10.setPessoa(pessoaCecilia);
        atuacao10.setInicio(LocalDate.of(2012, 01, 04));
        atuacao10.setTermino(LocalDate.of(2024, 01, 14));
        grupo4.getAtuacoes().add(atuacao10);
        pessoaCecilia.getAtuacoes().add(atuacao10);
        
        Atuacao atuacao12 = new Atuacao();
        atuacao11.setGrupo(grupo4);
        atuacao11.setPessoa(pessoaDebora);
        atuacao11.setInicio(LocalDate.of(2012, 01, 04));
        atuacao11.setTermino(LocalDate.of(2024, 01, 14));
        grupo4.getAtuacoes().add(atuacao11);
        pessoaDebora.getAtuacoes().add(atuacao11);
        
        
        // Persist:
        
        pessoaBean.save(pessoaAna);
        pessoaBean.save(pessoaBeatriz);
        pessoaBean.save(pessoaCecilia);
        pessoaBean.save(pessoaDebora);
    }
    
}
