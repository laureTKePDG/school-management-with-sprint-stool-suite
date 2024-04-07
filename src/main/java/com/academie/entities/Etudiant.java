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
@Table(name = "etudiant", catalog = "academie", schema = "")
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e"),
    @NamedQuery(name = "Etudiant.findByCodeEtud", query = "SELECT e FROM Etudiant e WHERE e.codeEtud = :codeEtud"),
    @NamedQuery(name = "Etudiant.findByNomEtud", query = "SELECT e FROM Etudiant e WHERE e.nomEtud = :nomEtud"),
    @NamedQuery(name = "Etudiant.findByPrenomEtud", query = "SELECT e FROM Etudiant e WHERE e.prenomEtud = :prenomEtud"),
    @NamedQuery(name = "Etudiant.findByTelEtud", query = "SELECT e FROM Etudiant e WHERE e.telEtud = :telEtud"),
    @NamedQuery(name = "Etudiant.findByMailEtud", query = "SELECT e FROM Etudiant e WHERE e.mailEtud = :mailEtud"),
    @NamedQuery(name = "Etudiant.findByAnneeEtud", query = "SELECT e FROM Etudiant e WHERE e.anneeEtud = :anneeEtud")})
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code_etud")
    private String codeEtud;
    @Basic(optional = false)
    @Column(name = "nom_etud")
    private String nomEtud;
    @Column(name = "prenom_etud")
    private String prenomEtud;
    @Basic(optional = false)
    @Column(name = "tel_etud")
    private String telEtud;
    @Basic(optional = false)
    @Column(name = "mail_etud")
    private String mailEtud;
    @Basic(optional = false)
    @Column(name = "annee_etud")
    private int anneeEtud;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiant")
    private List<Evaluation> evaluationList;*/

    public Etudiant() {
    }

    public Etudiant(String codeEtud) {
        this.codeEtud = codeEtud;
    }

    public Etudiant(String codeEtud, String nomEtud, String telEtud, String mailEtud, int anneeEtud) {
        this.codeEtud = codeEtud;
        this.nomEtud = nomEtud;
        this.telEtud = telEtud;
        this.mailEtud = mailEtud;
        this.anneeEtud = anneeEtud;
    }

    public String getCodeEtud() {
        return codeEtud;
    }

    public void setCodeEtud(String codeEtud) {
        this.codeEtud = codeEtud;
    }

    public String getNomEtud() {
        return nomEtud;
    }

    public void setNomEtud(String nomEtud) {
        this.nomEtud = nomEtud;
    }

    public String getPrenomEtud() {
        return prenomEtud;
    }

    public void setPrenomEtud(String prenomEtud) {
        this.prenomEtud = prenomEtud;
    }

    public String getTelEtud() {
        return telEtud;
    }

    public void setTelEtud(String telEtud) {
        this.telEtud = telEtud;
    }

    public String getMailEtud() {
        return mailEtud;
    }

    public void setMailEtud(String mailEtud) {
        this.mailEtud = mailEtud;
    }

    public int getAnneeEtud() {
        return anneeEtud;
    }

    public void setAnneeEtud(int anneeEtud) {
        this.anneeEtud = anneeEtud;
    }

	/*
	 * public List<Evaluation> getEvaluationList() { return evaluationList; }
	 * 
	 * public void setEvaluationList(List<Evaluation> evaluationList) {
	 * this.evaluationList = evaluationList; }
	 */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeEtud != null ? codeEtud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.codeEtud == null && other.codeEtud != null) || (this.codeEtud != null && !this.codeEtud.equals(other.codeEtud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.academie.entities.Etudiant[ codeEtud=" + codeEtud + " ]";
    }
    
}
