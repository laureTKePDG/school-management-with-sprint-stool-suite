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
@Table(name = "salle", catalog = "academie", schema = "")
@NamedQueries({
    @NamedQuery(name = "Salle.findAll", query = "SELECT s FROM Salle s"),
    @NamedQuery(name = "Salle.findByCodeSalle", query = "SELECT s FROM Salle s WHERE s.codeSalle = :codeSalle"),
    @NamedQuery(name = "Salle.findByNbPlace", query = "SELECT s FROM Salle s WHERE s.nbPlace = :nbPlace")})
public class Salle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code_salle")
    private String codeSalle;
    @Basic(optional = false)
    @Column(name = "nb_place")
    private int nbPlace;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "codeSalle")
    private List<Matiere> matiereList;*/

    public Salle() {
    }

    public Salle(String codeSalle) {
        this.codeSalle = codeSalle;
    }

    public Salle(String codeSalle, int nbPlace) {
        this.codeSalle = codeSalle;
        this.nbPlace = nbPlace;
    }

    public String getCodeSalle() {
        return codeSalle;
    }

    public void setCodeSalle(String codeSalle) {
        this.codeSalle = codeSalle;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    /*public List<Matiere> getMatiereList() {
        return matiereList;
    }

    public void setMatiereList(List<Matiere> matiereList) {
        this.matiereList = matiereList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeSalle != null ? codeSalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salle)) {
            return false;
        }
        Salle other = (Salle) object;
        if ((this.codeSalle == null && other.codeSalle != null) || (this.codeSalle != null && !this.codeSalle.equals(other.codeSalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.academie.entities.Salle[ codeSalle=" + codeSalle + " ]";
    }
    
}
