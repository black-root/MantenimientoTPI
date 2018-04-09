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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "Equipo_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipodetalle.findAll", query = "SELECT e FROM Equipodetalle e")
    , @NamedQuery(name = "Equipodetalle.findByPkEDnoSerie", query = "SELECT e FROM Equipodetalle e WHERE e.pkEDnoSerie = :pkEDnoSerie")
    , @NamedQuery(name = "Equipodetalle.findByNoInventario", query = "SELECT e FROM Equipodetalle e WHERE e.noInventario = :noInventario")
    , @NamedQuery(name = "Equipodetalle.findByPartNumber", query = "SELECT e FROM Equipodetalle e WHERE e.partNumber = :partNumber")
    , @NamedQuery(name = "Equipodetalle.findByModelo", query = "SELECT e FROM Equipodetalle e WHERE e.modelo = :modelo")
    , @NamedQuery(name = "Equipodetalle.findByHardwareSofware", query = "SELECT e FROM Equipodetalle e WHERE e.hardwareSofware = :hardwareSofware")
    , @NamedQuery(name = "Equipodetalle.findBySofware", query = "SELECT e FROM Equipodetalle e WHERE e.sofware = :sofware")
    , @NamedQuery(name = "Equipodetalle.findByVersion", query = "SELECT e FROM Equipodetalle e WHERE e.version = :version")
    , @NamedQuery(name = "Equipodetalle.findByArquitectura3264", query = "SELECT e FROM Equipodetalle e WHERE e.arquitectura3264 = :arquitectura3264")
    , @NamedQuery(name = "Equipodetalle.findByLicencia", query = "SELECT e FROM Equipodetalle e WHERE e.licencia = :licencia")})
public class Equipodetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_EDnoSerie")
    private String pkEDnoSerie;
    @Column(name = "noInventario")
    private String noInventario;
    @Column(name = "partNumber")
    private String partNumber;
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "hardware_sofware")
    private boolean hardwareSofware;
    @Column(name = "sofware")
    private String sofware;
    @Column(name = "version")
    private String version;
    @Column(name = "arquitectura3264")
    private Boolean arquitectura3264;
    @Column(name = "licencia")
    private Boolean licencia;
    @Lob
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipodetallepkEDnoSerie", fetch = FetchType.LAZY)
    private List<Dianosticoparte> dianosticoparteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipodetallepkEDnoSerie", fetch = FetchType.LAZY)
    private List<Equipodetalle> equipodetalleList;
    @JoinColumn(name = "Equipo_detalle_pk_EDnoSerie", referencedColumnName = "pk_EDnoSerie")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Equipodetalle equipodetallepkEDnoSerie;
    @JoinColumn(name = "fabricantes_idFabricante", referencedColumnName = "idFabricante")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Fabricantes fabricantesidFabricante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipodetallepkEDnoSerie", fetch = FetchType.LAZY)
    private List<Mantenimientodetalle> mantenimientodetalleList;

    public Equipodetalle() {
    }

    public Equipodetalle(String pkEDnoSerie) {
        this.pkEDnoSerie = pkEDnoSerie;
    }

    public Equipodetalle(String pkEDnoSerie, boolean hardwareSofware) {
        this.pkEDnoSerie = pkEDnoSerie;
        this.hardwareSofware = hardwareSofware;
    }

    public String getPkEDnoSerie() {
        return pkEDnoSerie;
    }

    public void setPkEDnoSerie(String pkEDnoSerie) {
        this.pkEDnoSerie = pkEDnoSerie;
    }

    public String getNoInventario() {
        return noInventario;
    }

    public void setNoInventario(String noInventario) {
        this.noInventario = noInventario;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean getHardwareSofware() {
        return hardwareSofware;
    }

    public void setHardwareSofware(boolean hardwareSofware) {
        this.hardwareSofware = hardwareSofware;
    }

    public String getSofware() {
        return sofware;
    }

    public void setSofware(String sofware) {
        this.sofware = sofware;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Boolean getArquitectura3264() {
        return arquitectura3264;
    }

    public void setArquitectura3264(Boolean arquitectura3264) {
        this.arquitectura3264 = arquitectura3264;
    }

    public Boolean getLicencia() {
        return licencia;
    }

    public void setLicencia(Boolean licencia) {
        this.licencia = licencia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<Dianosticoparte> getDianosticoparteList() {
        return dianosticoparteList;
    }

    public void setDianosticoparteList(List<Dianosticoparte> dianosticoparteList) {
        this.dianosticoparteList = dianosticoparteList;
    }

    @XmlTransient
    public List<Equipodetalle> getEquipodetalleList() {
        return equipodetalleList;
    }

    public void setEquipodetalleList(List<Equipodetalle> equipodetalleList) {
        this.equipodetalleList = equipodetalleList;
    }

    public Equipodetalle getEquipodetallepkEDnoSerie() {
        return equipodetallepkEDnoSerie;
    }

    public void setEquipodetallepkEDnoSerie(Equipodetalle equipodetallepkEDnoSerie) {
        this.equipodetallepkEDnoSerie = equipodetallepkEDnoSerie;
    }

    public Fabricantes getFabricantesidFabricante() {
        return fabricantesidFabricante;
    }

    public void setFabricantesidFabricante(Fabricantes fabricantesidFabricante) {
        this.fabricantesidFabricante = fabricantesidFabricante;
    }

    @XmlTransient
    public List<Mantenimientodetalle> getMantenimientodetalleList() {
        return mantenimientodetalleList;
    }

    public void setMantenimientodetalleList(List<Mantenimientodetalle> mantenimientodetalleList) {
        this.mantenimientodetalleList = mantenimientodetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkEDnoSerie != null ? pkEDnoSerie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipodetalle)) {
            return false;
        }
        Equipodetalle other = (Equipodetalle) object;
        if ((this.pkEDnoSerie == null && other.pkEDnoSerie != null) || (this.pkEDnoSerie != null && !this.pkEDnoSerie.equals(other.pkEDnoSerie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.Equipodetalle[ pkEDnoSerie=" + pkEDnoSerie + " ]";
    }
    
}
