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
@Table(name = "matiere", catalog = "academie", schema = "")
@NamedQueries({
    @NamedQuery(name = "Matiere.findAll", query = "SELECT m FROM Matiere m"),
    @NamedQuery(name = "Matiere.findByCodeMat", query = "SELECT m FROM Matiere m WHERE m.codeMat = :codeMat"),
    @NamedQuery(name = "Matiere.findByIntituleMat", query = "SELECT m FROM Matiere m WHERE m.intituleMat = :intituleMat"),
    @NamedQuery(name = "Matiere.findByVhMat", query = "SELECT m FROM Matiere m WHERE m.vhMat = :vhMat"),
    @NamedQuery(name = "Matiere.findByCreditMat", query = "SELECT m FROM Matiere m WHERE m.creditMat = :creditMat")})
public class Matiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code_mat")
    private String codeMat;
    @Basic(optional = false)
    @Column(name = "intitule_mat")
    private String intituleMat;
    @Basic(optional = false)
    @Column(name = "vh_mat")
    private int vhMat;
    @Column(name = "credit_mat")
    private Short creditMat;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "matiere")
    private List<Evaluation> evaluationList;*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeMat")
    private List<Enseignant> enseignantList;
    @JoinColumn(name = "code_salle", referencedColumnName = "code_salle")
    @ManyToOne(optional = false)
    private Salle codeSalle;

    public Matiere() {
    }

    public Matiere(String codeMat) {
        this.codeMat = codeMat;
    }

    public Matiere(String codeMat, String intituleMat, int vhMat) {
        this.codeMat = codeMat;
        this.intituleMat = intituleMat;
        this.vhMat = vhMat;
    }

    public String getCodeMat() {
        return codeMat;
    }

    public void setCodeMat(String codeMat) {
        this.codeMat = codeMat;
    }

    public String getIntituleMat() {
        return intituleMat;
    }

    public void setIntituleMat(String intituleMat) {
        this.intituleMat = intituleMat;
    }

    public int getVhMat() {
        return vhMat;
    }

    public void setVhMat(int vhMat) {
        this.vhMat = vhMat;
    }

    public Short getCreditMat() {
        return creditMat;
    }

    public void setCreditMat(Short creditMat) {
        this.creditMat = creditMat;
    }

    /*public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }*/

    public List<Enseignant> getEnseignantList() {
        return enseignantList;
    }

    public void setEnseignantList(List<Enseignant> enseignantList) {
        this.enseignantList = enseignantList;
    }

    public Salle getCodeSalle() {
        return codeSalle;
    }

    public void setCodeSalle(Salle codeSalle) {
        this.codeSalle = codeSalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeMat != null ? codeMat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matiere)) {
            return false;
        }
        Matiere other = (Matiere) object;
        if ((this.codeMat == null && other.codeMat != null) || (this.codeMat != null && !this.codeMat.equals(other.codeMat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.academie.entities.Matiere[ codeMat=" + codeMat + " ]";
    }
    
}
