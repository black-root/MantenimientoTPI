/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author sergio
 */
@Embeddable
public class DiagnosticoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "pK_idDiagnostico", nullable = false)
    private int pKidDiagnostico;
    @Basic(optional = false)
    @Column(name = "OrdenTrabajo_pk_idOrdenTrabajo", nullable = false)
    private int ordenTrabajopkidOrdenTrabajo;

    public DiagnosticoPK() {
    }

    public DiagnosticoPK(int pKidDiagnostico, int ordenTrabajopkidOrdenTrabajo) {
        this.pKidDiagnostico = pKidDiagnostico;
        this.ordenTrabajopkidOrdenTrabajo = ordenTrabajopkidOrdenTrabajo;
    }

    public int getPKidDiagnostico() {
        return pKidDiagnostico;
    }

    public void setPKidDiagnostico(int pKidDiagnostico) {
        this.pKidDiagnostico = pKidDiagnostico;
    }

    public int getOrdenTrabajopkidOrdenTrabajo() {
        return ordenTrabajopkidOrdenTrabajo;
    }

    public void setOrdenTrabajopkidOrdenTrabajo(int ordenTrabajopkidOrdenTrabajo) {
        this.ordenTrabajopkidOrdenTrabajo = ordenTrabajopkidOrdenTrabajo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pKidDiagnostico;
        hash += (int) ordenTrabajopkidOrdenTrabajo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagnosticoPK)) {
            return false;
        }
        DiagnosticoPK other = (DiagnosticoPK) object;
        if (this.pKidDiagnostico != other.pKidDiagnostico) {
            return false;
        }
        if (this.ordenTrabajopkidOrdenTrabajo != other.ordenTrabajopkidOrdenTrabajo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.DiagnosticoPK[ pKidDiagnostico=" + pKidDiagnostico + ", ordenTrabajopkidOrdenTrabajo=" + ordenTrabajopkidOrdenTrabajo + " ]";
    }
    
}
