/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Sessions;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.powermock.reflect.Whitebox;
import ues.fmoocc.ingenieria.tpi2018.Entities.Rol;

/**
 *
 * @author sergio
 */
public class RolFacadeTest {
    @Rule public EntityManagerProvider emProvider = new EntityManagerProvider("mantenimientoPU");
    public RolFacadeTest() {
    }
    
    
//
//    /**
//     * Test of find method, of class TipoMantenimientoFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        
//    }

    /**
     * Test of crear method, of class TipoMantenimientoFacade.
     */
    @Test
    public void testCrear() throws Exception {
        System.out.println("crear");
        EntityManager em = emProvider.em();
  
        Rol tipo1 = new Rol(1, "esto es una descripcion");
        Rol tipo2 = new Rol(2, "esto es una prueba");
        
        
        RolFacade Rf = new RolFacade();
        Whitebox.setInternalState(Rf, "em", em);
        
        Rf.getEntityManager().getTransaction().begin();
        
        boolean test1 = Rf.crear(null);
        boolean test2 = Rf.crear(tipo1);
        boolean test3 = Rf.crear(tipo2);

        assertFalse(test1);//verifica si no se crea un valor nulo
        assertTrue(test2);// verifica si se crean tipo1 y tipo2
        assertTrue(test3);
        assertEquals(2, Rf.findAll().size());//si se crean verifica en la bd cuantos datos hay
   }
//
//    /**
//     * Test of modificar method, of class TipoMantenimientoFacade.
//     */
//    @Test
//    public void testModificar() throws Exception {
//        
//    }
//
//    /**
//     * Test of eliminar method, of class TipoMantenimientoFacade.
//     */
//    @Test
//    public void testEliminar() throws Exception {
//        
//    }
//
//    /**
//     * Test of findAll method, of class TipoMantenimientoFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        
//    }
//
//    /**
//     * Test of findRange method, of class TipoMantenimientoFacade.
//     */
//    @Test
//    public void testFindRange() throws Exception {
//        
//    }
//
//    /**
//     * Test of count method, of class TipoMantenimientoFacade.
//     */
//    @Test
//    public void testCount() throws Exception {
//       
//    }
    
}
