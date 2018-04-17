/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmocc.ingenieria.tpi2018.Service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author viktor
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ues.fmocc.ingenieria.tpi2018.Service.FabricantesRestTest.class, 
    ues.fmocc.ingenieria.tpi2018.Service.RolRestTest.class, 
    ues.fmocc.ingenieria.tpi2018.Service.EstadoRestTest.class, 
    ues.fmocc.ingenieria.tpi2018.Service.HistorialTrabajoRestTest.class,  
    ues.fmocc.ingenieria.tpi2018.Service.OrdenTrabajoRestTest.class, 
    ues.fmocc.ingenieria.tpi2018.Service.TelefonoRestTest.class, 
    ues.fmocc.ingenieria.tpi2018.Service.PrioridadRestTest.class, 
    ues.fmocc.ingenieria.tpi2018.Service.TipoProcedimientoRestTest.class, 
    ues.fmocc.ingenieria.tpi2018.Service.Diagnostico_parteRestTest.class, 
    ues.fmocc.ingenieria.tpi2018.Service.PersonalRestTest.class, 
    ues.fmocc.ingenieria.tpi2018.Service.PasosRestTest.class, 
    ues.fmocc.ingenieria.tpi2018.Service.TipoMantenimientoRestTest.class,
    ues.fmocc.ingenieria.tpi2018.Service.SolicitudRestTest.class, 
    ues.fmocc.ingenieria.tpi2018.Service.UnidadRestTest.class, 
    ues.fmocc.ingenieria.tpi2018.Service.SubTipoMantenimientoRestTest.class, 
    ues.fmocc.ingenieria.tpi2018.Service.ProcedimientosRestTest.class,
    ues.fmocc.ingenieria.tpi2018.Service.DiagnosticoRestTest.class})
public class ServiceSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
