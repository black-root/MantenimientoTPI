/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Sessions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/**
 *
 * @author sergio
 */
public class EntityManagerProvider implements TestRule{
    protected static EntityManagerFactory emf;
    protected static EntityManager em;
    protected static EntityTransaction tx;
    
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

    EntityManagerProvider(String unitName) {
        this.em = Persistence.createEntityManagerFactory(unitName).createEntityManager();
        this.tx = this.em.getTransaction();
    }

    public final static EntityManagerProvider persistenceUnit(String unitName) {
        return new EntityManagerProvider(unitName);
    }

    public EntityManager em() {
        return this.em;
    }

    public EntityTransaction tx() {
        return this.tx;
    }

    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {

            @Override
            public void evaluate() throws Throwable {
                base.evaluate();
                em.clear();
            }

        };
    }

}


