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
import ues.fmoocc.ingenieria.tpi2018.Entities.Fabricantes;

/**
 *
 * @author viktor
 */
public class FabricantesRestTest {
    final FabricantesRest mokFabricantesRest = Mockito.mock(FabricantesRest.class);
    final Fabricantes mokFabricantes = Mockito.mock(Fabricantes.class);
    
    public FabricantesRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
       PowerMockito.whenNew(Fabricantes.class).withAnyArguments().thenReturn(mokFabricantes);
       Fabricantes d = new Fabricantes(1);
       Fabricantes d1 = new Fabricantes(2);
       List<Fabricantes> listaFabricantes =new ArrayList<>();
       listaFabricantes.add(d);
       listaFabricantes.add(d1);
       Mockito.when(mokFabricantesRest.findAll()).thenReturn(listaFabricantes);
       Mockito.when(mokFabricantesRest.findById(1)).thenReturn(d);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class FabricantesRest.
     */
    @Test
    public void testFindAll() throws Exception {
        FabricantesRest rest = mokFabricantesRest;
        List<Fabricantes> result = rest.findAll();
        Fabricantes fab = new Fabricantes(1);
        assertThat(result, CoreMatchers.hasItem(fab));
        assertNotNull(rest);
    }

    /**
     * Test of findById method, of class FabricantesRest.
     */
    @Test
    public void testFindById() throws Exception {
        int id=1;
        FabricantesRest instance = mokFabricantesRest;
        Fabricantes expResult = new Fabricantes(1);
        Fabricantes result = instance.findById(id);
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarFabricante method, of class FabricantesRest.
     */
    @Test
    public void testBorrarFabricante() throws Exception {
        int id=1;
        FabricantesRest instance = mokFabricantesRest;
        Fabricantes expResult = null;
        Response result = instance.borrarFabricante(id);
        assertNull(result);
        assertEquals(expResult, result);
        Mockito.verify(mokFabricantesRest, times(1)).borrarFabricante(id);
    }

    /**
     * Test of guardarFabricante method, of class FabricantesRest.
     */
    @Test
    public void testGuardarFabricante() throws Exception {
        int id=1;
        FabricantesRest instance = mokFabricantesRest;
        Fabricantes expResult = null;
        Response result = instance.guardarFabricante(mokFabricantes);
        assertNull(result);
        assertEquals(expResult, result);
        Mockito.verify(mokFabricantesRest, times(1)).guardarFabricante(mokFabricantes);
    }

    /**
     * Test of editarFabricante method, of class FabricantesRest.
     */
    @Test
    public void testEditarFabricante() throws Exception {
        int id=1;
        FabricantesRest instance = mokFabricantesRest;
        Fabricantes expResult = null;
        Response result = instance.editarFabricante(id, mokFabricantes);
        assertNull(result);
        assertEquals(expResult, result);
        Mockito.verify(mokFabricantesRest, times(1)).editarFabricante(id, mokFabricantes);
    }
    
}
