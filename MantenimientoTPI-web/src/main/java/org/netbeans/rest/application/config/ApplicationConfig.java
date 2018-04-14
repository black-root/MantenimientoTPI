/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;
import ues.fmocc.ingenieria.tpi2018.Service.*;

/**
 *
 * @author yisusdebian
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
//ir agregando las de mas clases
//Ronald
        resources.add(SolicitudRest.class);
        resources.add(PrioridadRest.class);
        resources.add(OrdenTrabajoRest.class);
        resources.add(SubTipoMantenimientoRest.class);
        resources.add(TipoMantenimientoRest.class);
        resources.add(UnidadRest.class);
        resources.add(HistorialTrabajoRest.class);
        resources.add(RolRest.class);
        resources.add(MantenimientoDetalleRest.class);
        resources.add(PersonalRest.class);
        
        resources.add(PasosRest.class);
        resources.add(TipoProcedimientoRest.class);
        resources.add(FabricantesRest.class);
        resources.add(Estado_detalleRest.class);
//Daniel metodos distintos 
    resources.add(Equipo_detalleRest.class);
        resources.add(EstadoRest.class);
        resources.add(ProcedimientosRest.class);
        resources.add(DiagnosticoRest.class);
        resources.add(DiagnosticoRest.class);
        resources.add(MantenimientoDetalleRest.class);

        resources.add(NewCrossOriginResourceSharingFilter.class);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {

        /*

        resources.add(org.netbeans.rest.application.config.NewCrossOriginResourceSharingFilter.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.DiagnosticoRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.Diagnostico_parteRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.Equipo_detalleRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.EstadoRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.Estado_detalleRest.class);

        resources.add(ues.fmocc.ingenieria.tpi2018.Service.FabricantesRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.PasosRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.RolRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.TipoProcedimientoRest.class);
        
         */
        resources.add(org.netbeans.rest.application.config.NewCrossOriginResourceSharingFilter.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.DiagnosticoRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.Diagnostico_parteRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.Equipo_detalleRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.EstadoRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.Estado_detalleRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.FabricantesRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.HistorialTrabajoRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.MantenimientoDetalleRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.OrdenTrabajoRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.PasosRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.PersonalRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.PrioridadRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.ProcedimientosRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.RolRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.SolicitudRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.SubTipoMantenimientoRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.TelefonoRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.TipoMantenimientoRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.TipoProcedimientoRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.UnidadRest.class);

    }

}
