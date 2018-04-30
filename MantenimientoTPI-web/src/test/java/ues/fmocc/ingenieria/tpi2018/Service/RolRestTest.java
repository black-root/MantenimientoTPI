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
import ues.fmoocc.ingenieria.tpi2018.Entities.Rol;

/**
 *
 * @author viktor
 */

public class RolRestTest {

    final RolRest mokRolRest = Mockito.mock(RolRest.class);
    final Rol mokRol = Mockito.mock(Rol.class);

    public RolRestTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Rol.class).withAnyArguments().thenReturn(mokRol);
        Mockito.when(mokRolRest.count()).thenReturn(1);
        Rol r = new Rol(1);
        Rol r1 = new Rol(2);
        List<Rol> listaRol = new ArrayList<>();
        listaRol.add(r);
        listaRol.add(r1);
        Mockito.when(mokRolRest.findall()).thenReturn(listaRol);
        Mockito.when(mokRolRest.findById(1)).thenReturn(r);
        Mockito.when(mokRolRest.create(mokRol)).thenReturn(Response.status(Response.Status.CREATED).build());
        Mockito.when(mokRolRest.edit(mokRol)).thenReturn(Response.status(Response.Status.OK).build());
        Mockito.when(mokRolRest.remove(1)).thenReturn(Response.status(Response.Status.OK).build());
        //Mockito.when(mokRolRest.findByDescripcion("descripcion")).thenReturn(listaRol);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findall method, of class RolRest.
     */
    @Test
    public void testFindall() {
        RolRest rest = mokRolRest;
        List<Rol> result = rest.findall();
        Rol rol = new Rol(1);
        assertThat(result, CoreMatchers.hasItems(rol));
    }

    /**
     * Test of count method, of class RolRest.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        RolRest instance = mokRolRest;
        int expResult = 1;
        int result = instance.count();
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class RolRest.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 1;
        RolRest instance = mokRolRest;
        Rol expResult = new Rol(1);
        Rol result = instance.findById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of findByDescripcion method, of class RolRest.
     */
//    @Test
//    public void testFindByDescripcion() {
//        System.out.println("findByDescripcion");
//        int id =1;
//        RolRest instance = mokRolRest;
//        Rol expResult = new Rol(1);
//        List<Rol> result = instance.findByDescripcion("descripcion");
//        assertThat(result, CoreMatchers.hasItem(expResult));
//        assertNotNull(result);
//    }
    /**
     * Test of remove method, of class RolRest.
     */
    @Test
    public void testBorrar() throws Exception {
        System.out.println("borrar");
        Integer id = 1;
        RolRest instance = mokRolRest;
        Response expResult = Response.status(200).build();
        Response result = instance.remove(id);
        assertEquals(expResult.getStatus(), result.getStatus());
        //(result);
        Mockito.verify(mokRolRest, times(1)).remove(id);
    }

    /**
     * Test of guardarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testGuardar() throws Exception {
        System.out.println("guardarDiagnosticoparte");
        int id = 1;
        RolRest instance = mokRolRest;
        Response expResult = Response.status(201).build();
        Response result = instance.create(mokRol);
        assertEquals(expResult.getStatus(), result.getStatus());
        assertNotNull(result);
        Mockito.verify(mokRolRest, times(1)).create(mokRol);

    }

    /**
     * Test of editarDiagnosticoparte method, of class Diagnostico_parteRest.
     */
    @Test
    public void testEditar() throws Exception {
        int id = 1;
        RolRest instance = mokRolRest;
        Response expResult = Response.status(200).build();
        Response result = instance.edit(mokRol);
        assertEquals(expResult.getStatus(), result.getStatus());
        //assertNull(result);
        Mockito.verify(mokRolRest, times(1)).edit(mokRol);

    }

}
