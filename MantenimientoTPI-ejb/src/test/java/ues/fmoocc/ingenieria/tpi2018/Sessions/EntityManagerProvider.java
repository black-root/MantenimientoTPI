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
        emf = Persistence.createEntityManagerFactory("mantenimientoPU");
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

    EntityManagerProvider() {
        this.em = Persistence.createEntityManagerFactory("mantenimientoPU").createEntityManager();
        this.tx = this.em.getTransaction();
    }

    public final static EntityManagerProvider persistenceUnit() {
        return new EntityManagerProvider();
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


