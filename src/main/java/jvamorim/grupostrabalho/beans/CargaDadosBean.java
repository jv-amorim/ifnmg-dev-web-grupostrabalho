package jvamorim.grupostrabalho.beans;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class CargaDadosBean implements CargaDadosBeanLocal {
    
    @PersistenceContext(unitName = "GruposTrabalhoPU")
    private EntityManager entityManager;
    
    @PostConstruct
    @Override
    public void popularBanco() {
        
    }
    
}
