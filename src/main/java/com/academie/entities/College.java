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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ASUS TUF A17
 */
@Entity
@Table(name = "college", catalog = "academie", schema = "")
@NamedQueries({
    @NamedQuery(name = "College.findAll", query = "SELECT c FROM College c"),
    @NamedQuery(name = "College.findBySite", query = "SELECT c FROM College c WHERE c.site = :site"),
    @NamedQuery(name = "College.findByLabel", query = "SELECT c FROM College c WHERE c.label = :label")})
public class College implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "site")
    private String site;
    @Basic(optional = false)
    @Column(name = "label")
    private String label;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "site")
    private List<Departement> departementList;

    public College() {
    }

    public College(String site) {
        this.site = site;
    }

    public College(String site, String label) {
        this.site = site;
        this.label = label;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Departement> getDepartementList() {
        return departementList;
    }

    public void setDepartementList(List<Departement> departementList) {
        this.departementList = departementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (site != null ? site.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof College)) {
            return false;
        }
        College other = (College) object;
        if ((this.site == null && other.site != null) || (this.site != null && !this.site.equals(other.site))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.academie.entities.College[ site=" + site + " ]";
    }
    
}
