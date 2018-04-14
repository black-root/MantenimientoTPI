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
import ues.fmoocc.ingenieria.tpi2018.Entities.Procedimientos;

/**
 *
 * @author viktor
 */
public class ProcedimientosRestTest {
    final ProcedimientosRest mokProcedimientosRest = Mockito.mock(ProcedimientosRest.class);
    final Procedimientos mokProcedimientos = Mockito.mock(Procedimientos.class);
    public ProcedimientosRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Procedimientos.class).withAnyArguments().thenReturn(mokProcedimientos);
        Procedimientos p = new Procedimientos(1, 1, 1);
        Procedimientos p1 = new Procedimientos(2, 2, 2);
        List<Procedimientos> listaProcedimientos = new ArrayList<>();
        listaProcedimientos.add(p);
        listaProcedimientos.add(p1);
        Mockito.when(mokProcedimientosRest.findAll()).thenReturn(listaProcedimientos);
        Mockito.when(mokProcedimientosRest.findById(1)).thenReturn(p);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class ProcedimientosRest.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
         ProcedimientosRest rest = mokProcedimientosRest;
        List<Procedimientos> result = rest.findAll();
        Procedimientos diagnostico = new Procedimientos(1, 1, 1);
        assertThat(result, CoreMatchers.hasItem(diagnostico));
        assertNotNull(rest);
    }

    /**
     * Test of findById method, of class ProcedimientosRest.
     */
    @Test
    public void testFindById() throws Exception {
       int id = 1; 
       ProcedimientosRest instance = mokProcedimientosRest;
       Procedimientos expResult = new Procedimientos(1, 1, 1);
       Procedimientos result = instance.findById(id);
       assertNotNull(result);
       assertEquals(expResult, result);
    }

    /**
     * Test of borrarProcedimiento method, of class ProcedimientosRest.
     */
    @Test
    public void testBorrarProcedimiento() throws Exception {
      int id = 1;
      ProcedimientosRest instance = mokProcedimientosRest;
       Procedimientos expResult = null;
       Response result = instance.borrarProcedimiento(id);
       assertNull(result);
       assertEquals(expResult, result);
       Mockito.verify(mokProcedimientosRest, times(1)).borrarProcedimiento(id);

    }

    /**
     * Test of guardarProcedimimento method, of class ProcedimientosRest.
     */
    @Test
    public void testGuardarProcedimimento() throws Exception {
        int id = 1;
      ProcedimientosRest instance = mokProcedimientosRest;
       Procedimientos expResult = null;
       Response result = instance.guardarProcedimimento(mokProcedimientos);
       assertNull(result);
       assertEquals(expResult, result);
       Mockito.verify(mokProcedimientosRest, times(1)).guardarProcedimimento(mokProcedimientos);

    }

    /**
     * Test of editarProcedimiento method, of class ProcedimientosRest.
     */
    @Test
    public void testEditarProcedimiento() throws Exception {
       int id = 1;
        ProcedimientosRest instance = mokProcedimientosRest;
       Procedimientos expResult = null;
       Response result = instance.editarProcedimiento(id, mokProcedimientos);
       assertNull(result);
       assertEquals(expResult, result);
       Mockito.verify(mokProcedimientosRest, times(1)).editarProcedimiento(id, mokProcedimientos);

    }
    
}
