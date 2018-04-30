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
import org.mockito.Matchers;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.powermock.api.mockito.PowerMockito;
import ues.fmoocc.ingenieria.tpi2018.Entities.Pasos;

/**
 *
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
        Mockito.when(mokPasosRest.findall()).thenReturn(listaPasos);
        Mockito.when(mokPasosRest.findById(1)).thenReturn(p);
        //Mockito.when(mokPasosRest.findByDescripcion("descripcion")).thenReturn(listaPasos);
        Mockito.when(mokPasosRest.create(mokPasos)).thenReturn(Response.status(Response.Status.CREATED).entity(p).build());
        Mockito.when(mokPasosRest.edit(mokPasos)).thenReturn(Response.status(Response.Status.OK).build());
        Mockito.when(mokPasosRest.remove(1)).thenReturn(Response.status(Response.Status.OK).build());   
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class PasosRest.
     */
    @Test
    public void testFindall() throws Exception {
        PasosRest rest = mokPasosRest;
        List<Pasos> result = rest.findall();
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

   @Test
    public void testCount() {
        System.out.println("count");
        PasosRest instance = mokPasosRest;
        int expResult =0;
        int result = instance.count();
         assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class PasosRest.
     */
    @Test
    public void testBorrarDiagnosticoparte() throws Exception {
        System.out.println("borrar");
        Integer id = 1;
        PasosRest instance = mokPasosRest;
        Response expResult = Response.status(200).build();
        Response result = instance.remove(id);
        assertEquals(expResult.getStatus(), result.getStatus());
        //(result);
        Mockito.verify(mokPasosRest, times(1)).remove(id);
    }

    /**
     * Test of guardarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testGuardarDiagnosticoparte() throws Exception {
        System.out.println("guardarDiagnosticoparte");
        int id = 1;
        PasosRest instance = mokPasosRest;
        Response expResult = Response.status(201).build();
        Response result = instance.create(mokPasos);
        assertEquals(expResult.getStatus(), result.getStatus());
        assertNotNull(result);
        Mockito.verify(mokPasosRest, times(1)).create(mokPasos);

    }

    /**
     * Test of editarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testEditarDiagnosticoparte() throws Exception {
        int id = 1;
        PasosRest instance = mokPasosRest;
        Response expResult = Response.status(200).build();
        Response result = instance.edit(mokPasos);
        assertEquals(expResult.getStatus(), result.getStatus());
        //assertNull(result);
        Mockito.verify(mokPasosRest, times(1)).edit(mokPasos);

    }
    
}
