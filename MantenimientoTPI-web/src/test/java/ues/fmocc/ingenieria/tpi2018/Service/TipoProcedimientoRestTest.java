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
import ues.fmoocc.ingenieria.tpi2018.Entities.Tipoprocedimiento;

/**
 *
 * @author viktor
 */
public class TipoProcedimientoRestTest {
    final TipoProcedimientoRest mokTPRest = Mockito.mock(TipoProcedimientoRest.class);
    final Tipoprocedimiento mokTP = Mockito.mock(Tipoprocedimiento.class);
    
    public TipoProcedimientoRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Tipoprocedimiento.class).withAnyArguments().thenReturn(mokTP);
        Tipoprocedimiento tp = new Tipoprocedimiento(1);
        Tipoprocedimiento tp1 = new Tipoprocedimiento(2);
        List<Tipoprocedimiento> listTp = new ArrayList<>();
        listTp.add(tp);
        listTp.add(tp1);
        Mockito.when(mokTPRest.findAll()).thenReturn(listTp);
        Mockito.when(mokTPRest.findById(1)).thenReturn(tp);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class TipoProcedimientoRest.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        TipoProcedimientoRest rest = mokTPRest;
        List<Tipoprocedimiento> result = rest.findAll();
        Tipoprocedimiento tp = new Tipoprocedimiento(1);
        assertThat(result, CoreMatchers.hasItem(tp));
        assertNotNull(result);
    }

    /**
     * Test of findById method, of class TipoProcedimientoRest.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        int id = 1;
        TipoProcedimientoRest instance = mokTPRest;
        Tipoprocedimiento expResult = new Tipoprocedimiento(1);
        Tipoprocedimiento result = instance.findById(id);
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarTipoProcedimiento method, of class TipoProcedimientoRest.
     */
    @Test
    public void testBorrarTipoProcedimiento() throws Exception {
        System.out.println("borrarTipoProcedimiento");
        int id = 1;
        TipoProcedimientoRest instance = mokTPRest;
        Tipoprocedimiento expResult = null;
        Response result = instance.borrarTipoProcedimiento(id);
        assertEquals(expResult, result);
        assertNull(result);
        Mockito.verify(mokTPRest, times(1)).borrarTipoProcedimiento(id);

    }

    /**
     * Test of guardarTipoProcedimiento method, of class TipoProcedimientoRest.
     */
    @Test
    public void testGuardarTipoProcedimiento() throws Exception {
        System.out.println("guardarTipoProcedimiento");
        int id=1;
        TipoProcedimientoRest instance = mokTPRest;
        Tipoprocedimiento expResult = null;
        Response result = instance.guardarTipoProcedimiento(mokTP);
        assertEquals(expResult, result);
        assertNull(result);
        Mockito.verify(mokTPRest, times(1)).guardarTipoProcedimiento(mokTP);

    }

    /**
     * Test of editarFabricante method, of class TipoProcedimientoRest.
     */
    @Test
    public void testEditarFabricante() throws Exception {
        System.out.println("editarFabricante");
        Integer id = null;
        TipoProcedimientoRest instance = mokTPRest;
        Tipoprocedimiento expResult = null;
        Response result = instance.editarFabricante(id, mokTP);
        assertEquals(expResult, result);
        assertNull(result);
        Mockito.verify(mokTPRest, times(1)).editarFabricante(id, mokTP);

    }
    
}
