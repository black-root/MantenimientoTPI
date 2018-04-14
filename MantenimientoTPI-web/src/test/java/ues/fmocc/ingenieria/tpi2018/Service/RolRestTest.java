/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmocc.ingenieria.tpi2018.Service;

import java.util.ArrayList;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Matchers;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.powermock.api.mockito.PowerMockito;
import ues.fmoocc.ingenieria.tpi2018.Entities.Rol;

/**
 *
 * @author viktor
 */
public class RolRestTest {
    final RolRest mokRolRest = Mockito.mock(RolRest.class);
    final Rol mokRol = Mockito.mock(Rol.class);
    
    public RolRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
      PowerMockito.whenNew(Rol.class).withAnyArguments().thenReturn(mokRol);
      Mockito.when(mokRolRest.count()).thenReturn(1);
      Rol r = new Rol(1);
      Rol r1 = new Rol(2);
      List<Rol> listaRol = new ArrayList<>();
      listaRol.add(r);
      listaRol.add(r1);
      Mockito.when(mokRolRest.findall()).thenReturn(listaRol);
      Mockito.when(mokRolRest.findById(1)).thenReturn(r);
      Mockito.when(mokRolRest.findByDescripcion("descripcion")).thenReturn(listaRol);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findall method, of class RolRest.
     */
    @Test
    public void testFindall() {
        RolRest rest = mokRolRest;
        List<Rol> result = rest.findall();
        Rol rol = new Rol(1);
        assertThat(result, CoreMatchers.hasItems(rol));
    }

    /**
     * Test of count method, of class RolRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        RolRest instance = mokRolRest;
        int expResult = 1;
        int result = instance.count();
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class RolRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id =1;
        RolRest instance = mokRolRest;
        Rol expResult = new Rol(1);
        Rol result = instance.findById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of findByDescripcion method, of class RolRest.
     */
    @Test
    public void testFindByDescripcion() {
        System.out.println("findByDescripcion");
        int id =1;
        RolRest instance = mokRolRest;
        Rol expResult = new Rol(1);
        List<Rol> result = instance.findByDescripcion("descripcion");
        assertThat(result, CoreMatchers.hasItem(expResult));
        assertNotNull(result);
    }

    /**
     * Test of remove method, of class RolRest.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
         Mockito.doNothing().when(mokRolRest).remove((Integer) Matchers.anyObject());
        
        mokRolRest.remove(Integer.SIZE);
        Mockito.verify(mokRolRest, times(1)).remove(Integer.SIZE);
        
        Mockito.doThrow(Exception.class).when(mokRolRest).remove(Integer.SIZE);
   
    }

    /**
     * Test of create method, of class RolRest.
     */
    @Test
    public void testCreate() {
        Mockito.doNothing().when(mokRolRest).create(mokRol);
        mokRolRest.create(mokRol);
        Mockito.verify(mokRolRest, times(1)).create(mokRol);
        Mockito.doThrow(Exception.class).when(mokRolRest).create(mokRol);
   
    }

    /**
     * Test of edit method, of class RolRest.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Mockito.doNothing().when(mokRolRest).edit(Integer.SIZE, mokRol);
        mokRolRest.edit(Integer.SIZE, mokRol);
        Mockito.verify(mokRolRest, times(1)).edit(Integer.SIZE, mokRol);
        Mockito.doThrow(Exception.class).when(mokRolRest).edit(Integer.SIZE, mokRol);
   
    }
    
}
