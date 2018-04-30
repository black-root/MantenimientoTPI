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
import org.mockito.Matchers;
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
       Mockito.when(mokFabricantesRest.findall()).thenReturn(listaFabricantes);
       Mockito.when(mokFabricantesRest.findById(1)).thenReturn(d);
       Mockito.when(mokFabricantesRest.findByNombre("nombre")).thenReturn(listaFabricantes);
       Mockito.when(mokFabricantesRest.create(mokFabricantes)).thenReturn(Response.status(Response.Status.CREATED).entity(d).build());
        Mockito.when(mokFabricantesRest.edit(mokFabricantes)).thenReturn(Response.status(Response.Status.OK).build());
        Mockito.when(mokFabricantesRest.remove(1)).thenReturn(Response.status(Response.Status.OK).build());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class FabricantesRest.
     */
    @Test
    public void testFindall() throws Exception {
        FabricantesRest rest = mokFabricantesRest;
        List<Fabricantes> result = rest.findall();
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

    @Test
    public void testFindByname(){
        String nombre= "nombre";
        FabricantesRest instance = mokFabricantesRest;
        Fabricantes d = new Fabricantes(1);
        Fabricantes d1 = new Fabricantes(2);
        List<Fabricantes> listaFabricantes =new ArrayList<>();
        listaFabricantes.add(d);
        listaFabricantes.add(d1);
        List<Fabricantes> result = instance.findByNombre(nombre);
        assertNotNull(result);
        assertEquals(listaFabricantes, result);
    }
    /**
     * Test of count method, of class FabricantesRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        FabricantesRest instance = mokFabricantesRest;
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
    }


     /**
     * Test of borrarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testBorrar() throws Exception {
        System.out.println("borrarDiagnosticoparte");
        Integer id = 1;
        FabricantesRest instance = mokFabricantesRest;
        Response expResult = Response.status(200).build();
        Response result = instance.remove(id);
        assertEquals(expResult.getStatus(), result.getStatus());
        //(result);
        Mockito.verify(mokFabricantesRest, times(1)).remove(id);
    }

    /**
     * Test of guardarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testGuardar() throws Exception {
        System.out.println("guardarDiagnosticoparte");
        int id = 1;
        FabricantesRest instance = mokFabricantesRest;
        Response expResult = Response.status(201).build();
        Response result = instance.create(mokFabricantes);
        assertEquals(expResult.getStatus(), result.getStatus());
        assertNotNull(result);
        Mockito.verify(mokFabricantesRest, times(1)).create(mokFabricantes);

    }

    /**
     * Test of editarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testEditarDiagnosticoparte() throws Exception {
        int id = 1;
        FabricantesRest instance = mokFabricantesRest;
        Response expResult = Response.status(200).build();
        Response result = instance.edit(mokFabricantes);
        assertEquals(expResult.getStatus(), result.getStatus());
        //assertNull(result);
        Mockito.verify(mokFabricantesRest, times(1)).edit(mokFabricantes);

    }
    
}
