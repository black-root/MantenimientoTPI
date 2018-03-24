/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yisusdebian
 */
@Entity
@Table(name = "Personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p")
    , @NamedQuery(name = "Personal.findByPkidPersonal", query = "SELECT p FROM Personal p WHERE p.pkidPersonal = :pkidPersonal")
    , @NamedQuery(name = "Personal.findByNombre", query = "SELECT p FROM Personal p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Personal.findByApellido", query = "SELECT p FROM Personal p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Personal.findByDui", query = "SELECT p FROM Personal p WHERE p.dui = :dui")
    , @NamedQuery(name = "Personal.findByNit", query = "SELECT p FROM Personal p WHERE p.nit = :nit")
    , @NamedQuery(name = "Personal.findByEstado", query = "SELECT p FROM Personal p WHERE p.estado = :estado")
    , @NamedQuery(name = "Personal.findByEmpleadoEstudiante", query = "SELECT p FROM Personal p WHERE p.empleadoEstudiante = :empleadoEstudiante")
    , @NamedQuery(name = "Personal.findByDue", query = "SELECT p FROM Personal p WHERE p.due = :due")
    , @NamedQuery(name = "Personal.findByDomicilio", query = "SELECT p FROM Personal p WHERE p.domicilio = :domicilio")})
public class Personal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idPersonal")
    private Integer pkidPersonal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dui")
    private String dui;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nit")
    private String nit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empleadoEstudiante")
    private boolean empleadoEstudiante;
    @Size(max = 45)
    @Column(name = "due")
    private String due;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "domicilio")
    private String domicilio;
    @ManyToMany(mappedBy = "personalList", fetch = FetchType.LAZY)
    private List<Estado> estadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personalpkidPersonal", fetch = FetchType.LAZY)
    private List<HistorialTrabajo> historialTrabajoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personalpkidPersonal", fetch = FetchType.LAZY)
    private List<Telefono> telefonoList;

    public Personal() {
    }

    public Personal(Integer pkidPersonal) {
        this.pkidPersonal = pkidPersonal;
    }

    public Personal(Integer pkidPersonal, String nombre, String apellido, String dui, String nit, boolean estado, boolean empleadoEstudiante, String domicilio) {
        this.pkidPersonal = pkidPersonal;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dui = dui;
        this.nit = nit;
        this.estado = estado;
        this.empleadoEstudiante = empleadoEstudiante;
        this.domicilio = domicilio;
    }

    public Integer getPkidPersonal() {
        return pkidPersonal;
    }

    public void setPkidPersonal(Integer pkidPersonal) {
        this.pkidPersonal = pkidPersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getEmpleadoEstudiante() {
        return empleadoEstudiante;
    }

    public void setEmpleadoEstudiante(boolean empleadoEstudiante) {
        this.empleadoEstudiante = empleadoEstudiante;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    @XmlTransient
    public List<Estado> getEstadoList() {
        return estadoList;
    }

    public void setEstadoList(List<Estado> estadoList) {
        this.estadoList = estadoList;
    }

    @XmlTransient
    public List<HistorialTrabajo> getHistorialTrabajoList() {
        return historialTrabajoList;
    }

    public void setHistorialTrabajoList(List<HistorialTrabajo> historialTrabajoList) {
        this.historialTrabajoList = historialTrabajoList;
    }

    @XmlTransient
    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidPersonal != null ? pkidPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.pkidPersonal == null && other.pkidPersonal != null) || (this.pkidPersonal != null && !this.pkidPersonal.equals(other.pkidPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.Personal[ pkidPersonal=" + pkidPersonal + " ]";
    }
    
}
