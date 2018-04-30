/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmocc.ingenieria.tpi2018.Service;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
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
        Mockito.when(mokTelefonoRest.create(mokTelefono)).thenReturn(Response.status(Response.Status.CREATED).build());
        Mockito.when(mokTelefonoRest.edit(mokTelefono)).thenReturn(Response.status(Response.Status.OK).build());
        Mockito.when(mokTelefonoRest.remove(1)).thenReturn(Response.status(Response.Status.OK).build());
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
    public void testBorrar() throws Exception {
        System.out.println("borrar");
        Integer id = 1;
        TelefonoRest instance = mokTelefonoRest;
        Response expResult = Response.status(200).build();
        Response result = instance.remove(id);
        assertEquals(expResult.getStatus(), result.getStatus());
        //(result);
        Mockito.verify(mokTelefonoRest, times(1)).remove(id);
    }

    /**
     * Test of guardarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testGuardar() throws Exception {
        System.out.println("guardarDiagnosticoparte");
        int id = 1;
        TelefonoRest instance = mokTelefonoRest;
        Response expResult = Response.status(201).build();
        Response result = instance.create(mokTelefono);
        assertEquals(expResult.getStatus(), result.getStatus());
        assertNotNull(result);
        Mockito.verify(mokTelefonoRest, times(1)).create(mokTelefono);

    }

    /**
     * Test of editarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testEditar() throws Exception {
        int id = 1;
        TelefonoRest instance = mokTelefonoRest;
        Response expResult = Response.status(200).build();
        Response result = instance.edit(mokTelefono);
        assertEquals(expResult.getStatus(), result.getStatus());
        //assertNull(result);
        Mockito.verify(mokTelefonoRest, times(1)).edit(mokTelefono);

    }
    
}
