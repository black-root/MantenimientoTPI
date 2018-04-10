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
import ues.fmoocc.ingenieria.tpi2018.Entities.Telefono;

/**
 *
 * @author viktor
 */
public class TelefonoRestTest {
    final TelefonoRest mokTelefonoRest = Mockito.mock(TelefonoRest.class);
    final Telefono mokTelefono = Mockito.mock(Telefono.class);
    
    public TelefonoRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Telefono.class).withAnyArguments().thenReturn(mokTelefono);
        Mockito.when(mokTelefonoRest.count()).thenReturn(1);
        Telefono t = new Telefono(1);
        Telefono t1 = new Telefono(2);
        List<Telefono> listaTel = new ArrayList<>();
        listaTel.add(t);
        listaTel.add(t1);
        Mockito.when(mokTelefonoRest.findall()).thenReturn(listaTel);
        Mockito.when(mokTelefonoRest.findById(1)).thenReturn(t);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findall method, of class TelefonoRest.
     */
    @Test
    public void testFindall() {
        System.out.println("findall");
        TelefonoRest instance = mokTelefonoRest;
        Telefono tel = new Telefono(1);
        List<Telefono> result = instance.findall();
        assertThat(result, CoreMatchers.hasItems(tel));
    }

    /**
     * Test of count method, of class TelefonoRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        TelefonoRest instance = mokTelefonoRest;
        int expResult = 1;
        int result = instance.count();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findById method, of class TelefonoRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id=1;
        TelefonoRest instance = mokTelefonoRest;
        Telefono expResult = new Telefono(1);
        Telefono result = instance.findById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class TelefonoRest.
     */
    @Test
    public void testRemove() {
        Mockito.doNothing().when(mokTelefonoRest).remove((Integer) Matchers.anyObject());
        mokTelefonoRest.remove(Integer.SIZE);
        Mockito.verify(mokTelefonoRest, times(1)).remove(Integer.SIZE);
        Mockito.doThrow(Exception.class).when(mokTelefonoRest).remove(Integer.SIZE);
   
    }

    /**
     * Test of create method, of class TelefonoRest.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
                Mockito.doNothing().when(mokTelefonoRest).create(mokTelefono);
        mokTelefonoRest.create(mokTelefono);
        Mockito.verify(mokTelefonoRest, times(1)).create(mokTelefono);
        Mockito.doThrow(Exception.class).when(mokTelefonoRest).create(mokTelefono);
    }

    /**
     * Test of edit method, of class TelefonoRest.
     */
    @Test
    public void testEdit() {
        
        Mockito.doNothing().when(mokTelefonoRest).edit(Integer.SIZE, mokTelefono);
        mokTelefonoRest.edit(Integer.SIZE, mokTelefono);
        Mockito.verify(mokTelefonoRest, times(1)).edit(Integer.SIZE, mokTelefono);
        Mockito.doThrow(Exception.class).when(mokTelefonoRest).edit(Integer.SIZE, mokTelefono);
    }
    
}
