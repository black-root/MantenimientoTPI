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
        resources.add(SolicitudRest.class);
        resources.add(PrioridadRest.class);
        
        resources.add(NewCrossOriginResourceSharingFilter.class);
        return resources;
    }
    private void addRestResourceClasses(Set<Class<?>> resources){
        resources.add(org.netbeans.rest.application.config.NewCrossOriginResourceSharingFilter.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.PrioridadRest.class);
        resources.add(ues.fmocc.ingenieria.tpi2018.Service.SolicitudRest.class);
    }  

    
}
