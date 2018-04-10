/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Sessions;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
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
    @Rule public EntityManagerProvider emProvider = new EntityManagerProvider();
    public RolFacadeTest() {
    }
    
    /**
     * Test of find method, of class TipoMantenimientoFacade.
     */
    @Test
    public void testFind() throws Exception {
        EntityManager em  = emProvider.em();
        Rol rol1 = new Rol(1, null);
        RolFacade rf = new RolFacade();
        Whitebox.setInternalState(rf, "em", em);
        rf.getEntityManager().getTransaction().begin();
        rf.getEntityManager().persist(rol1);
        assertEquals(rol1, rf.find(1));
        
    }

    /**
     * Test of crear method, of class TipoMantenimientoFacade.
     */
    @Test
    public void testCrear() throws Exception {
        EntityManager em = emProvider.em();
  
        Rol rol = new Rol(1, "esto es una descripcion");
        Rol rol1 = new Rol(2, "esto es una prueba");
        
        
        RolFacade Rf = new RolFacade();
        Whitebox.setInternalState(Rf, "em", em);
        
        Rf.getEntityManager().getTransaction().begin();
        
        boolean test1 = Rf.crear(null);
        boolean test2 = Rf.crear(rol);
        boolean test3 = Rf.crear(rol1);

        assertFalse(test1);//verifica si no se crea un valor nulo
        assertTrue(test2);// verifica si se crean tipo1 y tipo2
        assertTrue(test3);
        assertEquals(2, Rf.findAll().size());//si se crean verifica en la bd cuantos datos hay
   }

    /**
     * Test of modificar method, of class TipoMantenimientoFacade.
     */
    @Test
    public void testModificar() throws Exception {
        EntityManager em = emProvider.em();
        Rol rol1 = new Rol(1, "descripcion");
        RolFacade rf = new RolFacade();
        Whitebox.setInternalState(rf, "em", em);
        rf.getEntityManager().getTransaction().begin();
        rf.getEntityManager().persist(rol1);
        Rol esperado = new Rol(1, "otra descipcion");
        Rol r = rf.edit(esperado);
        assertNotNull(r.getPkidRol()); //revisando si la base de datos no esta vacia 
        assertEquals(esperado.getDescripcion(), r.getDescripcion());//revisando si edita en la base de datos 
    }

    /**
     * Test of eliminar method, of class TipoMantenimientoFacade.
     */
    @Test
    public void testEliminar() throws Exception {
        EntityManager em = emProvider.em();
        Rol rol1 = new Rol(1, "descripcion");
        RolFacade rf = new RolFacade();
        Whitebox.setInternalState(rf, "em", em);
        rf.getEntityManager().getTransaction().begin();
        rf.getEntityManager().persist(rol1);
        boolean resultado = rf.eliminar(rol1);
        boolean resultadoFalso = rf.eliminar(null);
        assertTrue(resultado);//
        assertFalse(resultadoFalso);
        assertEquals(0, rf.findAll().size());
    }

    /**
     * Test of findAll method, of class TipoMantenimientoFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        EntityManager em = emProvider.em();
        Rol rol1 = new Rol(1);
        Rol rol2 = new Rol(2);
        Rol rol3 = new Rol(3);
        ArrayList<Rol> list = new ArrayList<Rol>();
        list.add(0, rol1);
        list.add(1, rol2);
        list.add(2, rol3);
        RolFacade rf = new RolFacade();
        Whitebox.setInternalState(rf, "em", em);
        rf.getEntityManager().getTransaction().begin();
        rf.getEntityManager().persist(rol1);
        rf.getEntityManager().persist(rol2);
        rf.getEntityManager().persist(rol3);
        assertEquals(list.toString(), rf.findAll().toString());
        assertEquals(list.size(), rf.findAll().size());
    }
    

    /**
     * Test of findRange method, of class TipoMantenimientoFacade.
     */
    @Test
    public void testFindRange() throws Exception {
        EntityManager em = emProvider.em();
        
        Rol rol1 = new Rol(1);
        Rol rol2 = new Rol(2);
        List<Rol> list = new ArrayList<Rol>();
        list.add(rol1);
        list.add(rol2);
        RolFacade rf = new RolFacade();
        Whitebox.setInternalState(rf, "em", em);
        rf.getEntityManager().getTransaction().begin();
        rf.getEntityManager().persist(rol1);
        rf.getEntityManager().persist(rol2);
       // assertEquals(list.get(0), rf.findRange(0,1).get(0));
    }

    /**
     * Test of count method, of class TipoMantenimientoFacade.
     */
    @Test
    public void testCount() throws Exception {
        EntityManager em = emProvider.em();
        Rol rol1 = new Rol(1);
        Rol rol2 = new Rol(2);
        List<Rol> list = new ArrayList<>();
        list.add(rol1);
        list.add(rol2);
        RolFacade rf = new RolFacade();
        Whitebox.setInternalState(rf, "em", em);
        rf.getEntityManager().getTransaction().begin();
        rf.getEntityManager().persist(rol1);
        rf.getEntityManager().persist(rol2);
        assertEquals(list.size(), rf.count());
    }
    
    @Test 
    public void testfindWithDescripcion() throws Exception{
        EntityManager em = emProvider.em();
        Rol rol = new Rol(1, "esto es una prueba");
        Rol rol1 = new  Rol(2, "descripcion");
        RolFacade rf = new RolFacade();
        Whitebox.setInternalState(rf, "em", em);
        rf.getEntityManager().getTransaction().begin();
        rf.getEntityManager().persist(rol);
        rf.getEntityManager().persist(rol1);
        assertEquals(rol, rf.findWithDescripcion("Rol.findByDescripcion", rol.getDescripcion()).get(0));
    
    }
    
}
