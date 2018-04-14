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
import ues.fmoocc.ingenieria.tpi2018.Entities.Dianosticoparte;

/**
 *
 * @author viktor
 */
public class Diagnostico_parteRestTest {
    final Diagnostico_parteRest mokDiagnostico_parteRest = Mockito.mock(Diagnostico_parteRest.class);
    final Dianosticoparte mokDianosticoparte = Mockito.mock(Dianosticoparte.class); 
    public Diagnostico_parteRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Dianosticoparte.class).withAnyArguments().thenReturn(mokDianosticoparte);
        Dianosticoparte d = new Dianosticoparte(1, "descripcion");
        Dianosticoparte d2 = new Dianosticoparte(2, "descripcion");
        List<Dianosticoparte> listadianosticoparte = new ArrayList<>();
        listadianosticoparte.add(d);
        listadianosticoparte.add(d2);
        Mockito.when(mokDiagnostico_parteRest.findAll()).thenReturn(listadianosticoparte);
        Mockito.when(mokDiagnostico_parteRest.findById(1)).thenReturn(d);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class Diagnostico_parteRest.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Diagnostico_parteRest rest = mokDiagnostico_parteRest;
        List<Dianosticoparte> result = rest.findAll();
        Dianosticoparte diagParte = new Dianosticoparte(1, "descripcion");
        assertThat(result, CoreMatchers.hasItem(diagParte));
        assertNotNull(rest);
    }

    /**
     * Test of findById method, of class Diagnostico_parteRest.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        int id = 1;
        Diagnostico_parteRest instance = mokDiagnostico_parteRest;
        Dianosticoparte expResult = new Dianosticoparte(1, "descripcion");
        Dianosticoparte result = instance.findById(id);
        //assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testBorrarDiagnosticoparte() throws Exception {
        System.out.println("borrarDiagnosticoparte");
        Integer id = null;
        Diagnostico_parteRest instance = mokDiagnostico_parteRest;
        Dianosticoparte expResult = null;
        Response result = instance.borrarDiagnosticoparte(id);
        assertEquals(expResult, result);
        assertNull(result);
        Mockito.verify(mokDiagnostico_parteRest,times(1)).borrarDiagnosticoparte(id);
    }

    /**
     * Test of guardarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testGuardarDiagnosticoparte() throws Exception {
        System.out.println("guardarDiagnosticoparte");
        int id = 1;
        Diagnostico_parteRest instance = mokDiagnostico_parteRest;
        Dianosticoparte expResult = null;
        Response result= instance.guardarDiagnosticoparte(mokDianosticoparte);
        assertEquals(expResult, result);
        assertNull(result);
        Mockito.verify(mokDiagnostico_parteRest,times(1)).guardarDiagnosticoparte(mokDianosticoparte);
            
    }

    /**
     * Test of editarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testEditarDiagnosticoparte() throws Exception {
     int id=1;
        Diagnostico_parteRest instance = mokDiagnostico_parteRest;
        Dianosticoparte expResult = null;
        Response result= instance.editarDiagnosticoparte(id, expResult);
        assertEquals(expResult, result);
        assertNull(result);
        Mockito.verify(mokDiagnostico_parteRest,times(1)).editarDiagnosticoparte(id, expResult);
   
    }
    
}
