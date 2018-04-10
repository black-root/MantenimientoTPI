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
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.powermock.api.mockito.PowerMockito;
import ues.fmoocc.ingenieria.tpi2018.Entities.Pasos;

/**
 *
 * @author viktor
 */
public class PasosRestTest {
    final PasosRest mokPasosRest = Mockito.mock(PasosRest.class);
    final Pasos mokPasos = Mockito.mock(Pasos.class);
    
    public PasosRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Pasos.class).withAnyArguments().thenReturn(mokPasos);
        Pasos p = new Pasos(1);
        Pasos p1 = new Pasos(2);
        List<Pasos> listaPasos = new ArrayList<>();
        listaPasos.add(p);
        listaPasos.add(p1);
        Mockito.when(mokPasosRest.findAll()).thenReturn(listaPasos);
        Mockito.when(mokPasosRest.findById(1)).thenReturn(p);
            
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class PasosRest.
     */
    @Test
    public void testFindAll() throws Exception {
        PasosRest rest = mokPasosRest;
        List<Pasos> result = rest.findAll();
        Pasos pas = new Pasos(1);
        assertThat(result, CoreMatchers.hasItem(pas));
        assertNotNull(rest);
    }

    /**
     * Test of findById method, of class PasosRest.
     */
    @Test
    public void testFindById() throws Exception {
        int id = 1;
        PasosRest instance = mokPasosRest;
        Pasos expResult = new Pasos(1);
        Pasos result = instance.findById(id);
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarPaso method, of class PasosRest.
     */
    @Test
    public void testBorrarPaso() throws Exception {
        int id = 1;
        PasosRest instance = mokPasosRest;
        Pasos expResult = null;
        Response result = instance.borrarPaso(id);
        assertNull(result);
        assertEquals(expResult, result);
        Mockito.verify(mokPasosRest, times(1)).borrarPaso(id);
    }

    /**
     * Test of guardarPaso method, of class PasosRest.
     */
    @Test
    public void testGuardarPaso() throws Exception {
        int id = 1;
        PasosRest instance = mokPasosRest;
        Pasos expResult = null;
        Response result = instance.guardarPaso(mokPasos);
        assertNull(result);
        assertEquals(expResult, result);
        Mockito.verify(mokPasosRest, times(1)).guardarPaso(mokPasos);
    }

    /**
     * Test of editarPaso method, of class PasosRest.
     */
    @Test
    public void testEditarPaso() throws Exception {
        int id = 1;
        PasosRest instance = mokPasosRest;
        Pasos expResult = null;
        Response result = instance.editarPaso(id, mokPasos);
        assertNull(result);
        assertEquals(expResult, result);
        Mockito.verify(mokPasosRest, times(1)).editarPaso(id, mokPasos);
    }
    
}
