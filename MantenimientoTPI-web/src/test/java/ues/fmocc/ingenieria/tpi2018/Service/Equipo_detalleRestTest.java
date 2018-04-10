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
import ues.fmoocc.ingenieria.tpi2018.Entities.Equipodetalle;

/**
 *
 * @author viktor
 */
public class Equipo_detalleRestTest {
    final Equipo_detalleRest mokEquipo_detalleRest = Mockito.mock(Equipo_detalleRest.class);
    final Equipodetalle mokEquipodetalle = Mockito.mock(Equipodetalle.class);
    
    public Equipo_detalleRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
     PowerMockito.whenNew(Equipodetalle.class).withAnyArguments().thenReturn(mokEquipodetalle);
     Equipodetalle d = new Equipodetalle("1", true);
     Equipodetalle d1 = new Equipodetalle("2", false);
     List<Equipodetalle> listaEquipodetalle = new ArrayList<>();
     listaEquipodetalle.add(d);
     listaEquipodetalle.add(d1);
     Mockito.when(mokEquipo_detalleRest.findAll()).thenReturn(listaEquipodetalle);
     Mockito.when(mokEquipo_detalleRest.findById(1)).thenReturn(d);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class Equipo_detalleRest.
     */
    @Test
    public void testFindAll() throws Exception {
        Equipo_detalleRest rest = mokEquipo_detalleRest;
        List<Equipodetalle> result = rest.findAll();
        Equipodetalle EdDetalle = new Equipodetalle("1", true);
        assertThat(result, CoreMatchers.hasItem(EdDetalle));
        assertNotNull(rest);
    }

    /**
     * Test of findById method, of class Equipo_detalleRest.
     */
    @Test
    public void testFindById() throws Exception {
        int id =1;
        Equipo_detalleRest instance = mokEquipo_detalleRest;
        Equipodetalle expResult = new Equipodetalle("1", true);
        Equipodetalle result = instance.findById(id);
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarEquipodetalle method, of class Equipo_detalleRest.
     */
    @Test
    public void testBorrarEquipodetalle() throws Exception {
        int id=1;
        Equipo_detalleRest instance = mokEquipo_detalleRest;
        Equipodetalle expResult = null;
        Response result = instance.borrarEquipodetalle(id);
        assertEquals(expResult, result);
        assertNull(result);
        Mockito.verify(mokEquipo_detalleRest, times(1)).borrarEquipodetalle(id);
    }

    /**
     * Test of guardarEquipodetalle method, of class Equipo_detalleRest.
     */
    @Test
    public void testGuardarEquipodetalle() throws Exception {
        int id=1;
        Equipo_detalleRest instance = mokEquipo_detalleRest;
        Equipodetalle expResult=null;
        Response result = instance.guardarEquipodetalle(mokEquipodetalle);
          assertEquals(expResult, result);
        assertNull(result);
        Mockito.verify(mokEquipo_detalleRest, times(1)).guardarEquipodetalle(mokEquipodetalle);

    }

    /**
     * Test of editarEquipodetalle method, of class Equipo_detalleRest.
     */
    @Test
    public void testEditarEquipodetalle() throws Exception {
        int id = 1;
        Equipo_detalleRest instance = mokEquipo_detalleRest;
        Equipodetalle expResult=null;
        Response result = instance.editarEquipodetalle(id,mokEquipodetalle);
         assertEquals(expResult, result);
        assertNull(result);
        Mockito.verify(mokEquipo_detalleRest, times(1)).editarEquipodetalle(id,mokEquipodetalle);

    }
    
}
