/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "Procedimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procedimientos.findAll", query = "SELECT p FROM Procedimientos p")
    , @NamedQuery(name = "Procedimientos.findByNombreProcedimiento", query = "SELECT p FROM Procedimientos p WHERE p.nombreProcedimiento = :nombreProcedimiento")
    , @NamedQuery(name = "Procedimientos.findByTipoprocedimientopkidTipoprocedimiento", query = "SELECT p FROM Procedimientos p WHERE p.procedimientosPK.tipoprocedimientopkidTipoprocedimiento = :tipoprocedimientopkidTipoprocedimiento")
    , @NamedQuery(name = "Procedimientos.findByPasospkidPaso", query = "SELECT p FROM Procedimientos p WHERE p.procedimientosPK.pasospkidPaso = :pasospkidPaso")
    , @NamedQuery(name = "Procedimientos.findByDiagnosticopartepkidDianosticoparte", query = "SELECT p FROM Procedimientos p WHERE p.procedimientosPK.diagnosticopartepkidDianosticoparte = :diagnosticopartepkidDianosticoparte")})
public class Procedimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcedimientosPK procedimientosPK;
    @Column(name = "nombre_Procedimiento")
    private String nombreProcedimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedimientos")
    private Collection<Estado> estadoCollection;
    @JoinColumn(name = "Diagnostico_parte_pk_idDianostico_parte", referencedColumnName = "pk_idDianostico_parte", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Diagnosticoparte diagnosticoparte;
    @JoinColumn(name = "Pasos_pk_idPaso", referencedColumnName = "pk_idPaso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pasos pasos;
    @JoinColumn(name = "Tipo_procedimiento_pk_idTipo_procedimiento", referencedColumnName = "pk_idTipo_procedimiento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tipoprocedimiento tipoprocedimiento;

    public Procedimientos() {
    }

    public Procedimientos(ProcedimientosPK procedimientosPK) {
        this.procedimientosPK = procedimientosPK;
    }

    public Procedimientos(int tipoprocedimientopkidTipoprocedimiento, int pasospkidPaso, int diagnosticopartepkidDianosticoparte) {
        this.procedimientosPK = new ProcedimientosPK(tipoprocedimientopkidTipoprocedimiento, pasospkidPaso, diagnosticopartepkidDianosticoparte);
    }

    public ProcedimientosPK getProcedimientosPK() {
        return procedimientosPK;
    }

    public void setProcedimientosPK(ProcedimientosPK procedimientosPK) {
        this.procedimientosPK = procedimientosPK;
    }

    public String getNombreProcedimiento() {
        return nombreProcedimiento;
    }

    public void setNombreProcedimiento(String nombreProcedimiento) {
        this.nombreProcedimiento = nombreProcedimiento;
    }

    @XmlTransient
    public Collection<Estado> getEstadoCollection() {
        return estadoCollection;
    }

    public void setEstadoCollection(Collection<Estado> estadoCollection) {
        this.estadoCollection = estadoCollection;
    }

    public Diagnosticoparte getDiagnosticoparte() {
        return diagnosticoparte;
    }

    public void setDiagnosticoparte(Diagnosticoparte diagnosticoparte) {
        this.diagnosticoparte = diagnosticoparte;
    }

    public Pasos getPasos() {
        return pasos;
    }

    public void setPasos(Pasos pasos) {
        this.pasos = pasos;
    }

    public Tipoprocedimiento getTipoprocedimiento() {
        return tipoprocedimiento;
    }

    public void setTipoprocedimiento(Tipoprocedimiento tipoprocedimiento) {
        this.tipoprocedimiento = tipoprocedimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procedimientosPK != null ? procedimientosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procedimientos)) {
            return false;
        }
        Procedimientos other = (Procedimientos) object;
        if ((this.procedimientosPK == null && other.procedimientosPK != null) || (this.procedimientosPK != null && !this.procedimientosPK.equals(other.procedimientosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmocc.ingenieria.tpi2018.Entities.Procedimientos[ procedimientosPK=" + procedimientosPK + " ]";
    }
    
}
