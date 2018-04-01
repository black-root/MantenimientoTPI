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
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ues.fmoocc.ingenieria.tpi2018.Entities.OrdenTrabajo;
import ues.fmoocc.ingenieria.tpi2018.Entities.Prioridad;
import ues.fmoocc.ingenieria.tpi2018.Sessions.PrioridadFacadeLocal;

/**
 *
 * @author sergio
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(PrioridadRest.class)
public class PrioridadRestTest {
    
    public PrioridadRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findall method, of class PrioridadRest.
     */
    @Test
    public void testFindall() {
        System.out.println("findall");      
        PrioridadRest rest = new PrioridadRest();
        List<Prioridad> expResult = new ArrayList<>();
        PrioridadFacadeLocal mokpri = Mockito.mock(PrioridadFacadeLocal.class);
        Prioridad p = new Prioridad();
        OrdenTrabajo ot = Mockito.mock(OrdenTrabajo.class);
        List<OrdenTrabajo> listaorden = new ArrayList<>();
        listaorden.add(ot);
        p.setOrdenTrabajoList(listaorden);
        p.setPkidPrioridad(1);
        p.setPrioridadNivel("1");
        expResult.add(p);
        Mockito.when(mokpri.findAll()).thenReturn(expResult);
        List<Prioridad> result = mokpri.findAll();
        assertThat(result, CoreMatchers.hasItems(p));
       
    }

    /**
     * Test of count method, of class PrioridadRest.
     * @throws java.lang.Exception
     */
    @Test(expected = Exception.class)
    public void testCount() throws Exception {
        System.out.println("count");
        PrioridadRest rest = new PrioridadRest();
        PrioridadFacadeLocal mokpri = Mockito.mock(PrioridadFacadeLocal.class);
        Mockito.when(mokpri.count()).thenReturn(1);
        PowerMockito.whenNew(PrioridadFacadeLocal.class).withAnyArguments().thenReturn(mokpri);
        int result = rest.count();
        assertEquals(1, result);
    }

    /**
     * Test of findById method, of class PrioridadRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = null;
        PrioridadRest instance = new PrioridadRest();
        Prioridad expResult = null;
        Prioridad result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
