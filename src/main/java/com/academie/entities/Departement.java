/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.academie.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ASUS TUF A17
 */
@Entity
@Table(name = "departement", catalog = "academie", schema = "")
@NamedQueries({
    @NamedQuery(name = "Departement.findAll", query = "SELECT d FROM Departement d"),
    @NamedQuery(name = "Departement.findByLabelDepart", query = "SELECT d FROM Departement d WHERE d.labelDepart = :labelDepart")})
public class Departement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "label_depart")
    private String labelDepart;
    @JoinColumn(name = "site", referencedColumnName = "site")
    @ManyToOne(optional = false)
    private College site;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "labelDepart")
    private List<Enseignant> enseignantList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "labelDepartContenir")
    private List<Enseignant> enseignantList1;

    public Departement() {
    }

    public Departement(String labelDepart) {
        this.labelDepart = labelDepart;
    }

    public String getLabelDepart() {
        return labelDepart;
    }

    public void setLabelDepart(String labelDepart) {
        this.labelDepart = labelDepart;
    }

    public College getSite() {
        return site;
    }

    public void setSite(College site) {
        this.site = site;
    }

    public List<Enseignant> getEnseignantList() {
        return enseignantList;
    }

    public void setEnseignantList(List<Enseignant> enseignantList) {
        this.enseignantList = enseignantList;
    }

    public List<Enseignant> getEnseignantList1() {
        return enseignantList1;
    }

    public void setEnseignantList1(List<Enseignant> enseignantList1) {
        this.enseignantList1 = enseignantList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (labelDepart != null ? labelDepart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departement)) {
            return false;
        }
        Departement other = (Departement) object;
        if ((this.labelDepart == null && other.labelDepart != null) || (this.labelDepart != null && !this.labelDepart.equals(other.labelDepart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.academie.entities.Departement[ labelDepart=" + labelDepart + " ]";
    }
    
}
