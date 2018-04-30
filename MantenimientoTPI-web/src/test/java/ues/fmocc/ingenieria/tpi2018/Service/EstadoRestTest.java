/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmocc.ingenieria.tpi2018.Service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.ws.rs.core.Response;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.powermock.api.mockito.PowerMockito;
import ues.fmoocc.ingenieria.tpi2018.Entities.Estado;

/**
 *
 * @author viktor
 */
@Ignore
public class EstadoRestTest {
    final EstadoRest mokEstadoRest = Mockito.mock(EstadoRest.class);
    final Estado mokEstado = Mockito.mock(Estado.class);
    public EstadoRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Estado.class).withAnyArguments().thenReturn(mokEstado);
        Estado d= new Estado(0, 0, 0, 0);
        Estado d1= new Estado(1, 1, 1, 1);
        List<Estado> listaEstado = new ArrayList<>();
        listaEstado.add(d);
        listaEstado.add(d1);
        Mockito.when(mokEstadoRest.findAll()).thenReturn(listaEstado);
        Mockito.when(mokEstadoRest.findById(1)).thenReturn(d);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class EstadoRest.
     */
    @Test
    public void testFindAll() throws Exception {
        EstadoRest rest = mokEstadoRest;
        List<Estado> result = rest.findAll();
        Estado estado = new Estado(0, 0, 0, 0);
        assertThat(result, CoreMatchers.hasItem(estado));
        assertNotNull(rest);
    }

    /**
     * Test of findById method, of class EstadoRest.
     */
    @Test
    public void testFindById() throws Exception {
        int id=1;
        EstadoRest instance = mokEstadoRest;
        Estado expResult = new Estado(0, 0, 0, 0);
        Estado result = instance.findById(id);
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarEstado method, of class EstadoRest.
     */
    @Test
    public void testBorrarEstado() throws Exception {
        int id=1;
        EstadoRest instance = mokEstadoRest;
        Estado expResult = null;
        Response result = instance.create(mokEstado);
         assertEquals(expResult, result);
        assertNull(result);
        Mockito.verify(mokEstadoRest, times(1)).create(mokEstado);

    }

    /**
     * Test of guardarEstado method, of class EstadoRest.
     */
    @Test
    public void testGuardarEstado() throws Exception {
        int id=1;
        EstadoRest instance = mokEstadoRest;
        Estado expResult = null;
        Response result = instance.edit(mokEstado);
         assertEquals(expResult, result);
        assertNull(result);
        Mockito.verify(mokEstadoRest, times(1)).edit(mokEstado);;
    }

    /**
     * Test of editarEstado method, of class EstadoRest.
     */
    @Test
    public void testEditarEstado() throws Exception {
        int id=1;
        EstadoRest instance = mokEstadoRest;
        Estado expResult = null;
        Response result = instance.edit(mokEstado);
         assertEquals(expResult, result);
        assertNull(result);
        Mockito.verify(mokEstadoRest, times(1)).edit(mokEstado);
   
    }
    
}
