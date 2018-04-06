/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Sessions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 *
 * @author sergio
 */
public class EntityManagerProvider implements TestRule{
    protected static EntityManagerFactory emf;
    public static EntityManager em; 
    
    @BeforeClass
    public static void init(){
        emf = Persistence.createEntityManagerFactory("mantenimientoTestPU");
        em = emf.createEntityManager();
    
    }
    @After
    public void cleanUp(){
        em.getTransaction().rollback();
    }
    @AfterClass
    public static void tearDown(){
        em.clear();
        em.close();
        emf.close();
    }
    
    


    @Override
    public Statement apply(Statement stmnt, Description d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
