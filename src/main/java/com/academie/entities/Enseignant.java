/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.academie.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ASUS TUF A17
 */
@Entity
@Table(name = "enseignant", catalog = "academie", schema = "")
@NamedQueries({
    @NamedQuery(name = "Enseignant.findAll", query = "SELECT e FROM Enseignant e"),
    @NamedQuery(name = "Enseignant.findByCodeEns", query = "SELECT e FROM Enseignant e WHERE e.codeEns = :codeEns"),
    @NamedQuery(name = "Enseignant.findByNomEns", query = "SELECT e FROM Enseignant e WHERE e.nomEns = :nomEns"),
    @NamedQuery(name = "Enseignant.findByPrenomEns", query = "SELECT e FROM Enseignant e WHERE e.prenomEns = :prenomEns"),
    @NamedQuery(name = "Enseignant.findByTelEns", query = "SELECT e FROM Enseignant e WHERE e.telEns = :telEns"),
    @NamedQuery(name = "Enseignant.findByMailEns", query = "SELECT e FROM Enseignant e WHERE e.mailEns = :mailEns"),
    @NamedQuery(name = "Enseignant.findByDateFonction", query = "SELECT e FROM Enseignant e WHERE e.dateFonction = :dateFonction"),
    @NamedQuery(name = "Enseignant.findByIndiceEns", query = "SELECT e FROM Enseignant e WHERE e.indiceEns = :indiceEns")})
public class Enseignant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code_ens")
    private String codeEns;
    @Basic(optional = false)
    @Column(name = "nom_ens")
    private String nomEns;
    @Column(name = "prenom_ens")
    private String prenomEns;
    @Basic(optional = false)
    @Column(name = "tel_ens")
    private String telEns;
    @Column(name = "mail_ens")
    private String mailEns;
    @Basic(optional = false)
    @Column(name = "date_fonction")
    @Temporal(TemporalType.DATE)
    private Date dateFonction;
    @Basic(optional = false)
    @Column(name = "indice_ens")
    private int indiceEns;
    @JoinColumn(name = "label_depart", referencedColumnName = "label_depart")
    @ManyToOne(optional = false)
    private Departement labelDepart;
    @JoinColumn(name = "label_depart_contenir", referencedColumnName = "label_depart")
    @ManyToOne(optional = false)
    private Departement labelDepartContenir;
    @JoinColumn(name = "code_mat", referencedColumnName = "code_mat")
    @ManyToOne(optional = false)
    private Matiere codeMat;

    public Enseignant() {
    }

    public Enseignant(String codeEns) {
        this.codeEns = codeEns;
    }

    public Enseignant(String codeEns, String nomEns, String telEns, Date dateFonction, int indiceEns) {
        this.codeEns = codeEns;
        this.nomEns = nomEns;
        this.telEns = telEns;
        this.dateFonction = dateFonction;
        this.indiceEns = indiceEns;
    }

    public String getCodeEns() {
        return codeEns;
    }

    public void setCodeEns(String codeEns) {
        this.codeEns = codeEns;
    }

    public String getNomEns() {
        return nomEns;
    }

    public void setNomEns(String nomEns) {
        this.nomEns = nomEns;
    }

    public String getPrenomEns() {
        return prenomEns;
    }

    public void setPrenomEns(String prenomEns) {
        this.prenomEns = prenomEns;
    }

    public String getTelEns() {
        return telEns;
    }

    public void setTelEns(String telEns) {
        this.telEns = telEns;
    }

    public String getMailEns() {
        return mailEns;
    }

    public void setMailEns(String mailEns) {
        this.mailEns = mailEns;
    }

    public Date getDateFonction() {
        return dateFonction;
    }

    public void setDateFonction(Date dateFonction) {
        this.dateFonction = dateFonction;
    }

    public int getIndiceEns() {
        return indiceEns;
    }

    public void setIndiceEns(int indiceEns) {
        this.indiceEns = indiceEns;
    }

    public Departement getLabelDepart() {
        return labelDepart;
    }

    public void setLabelDepart(Departement labelDepart) {
        this.labelDepart = labelDepart;
    }

    public Departement getLabelDepartContenir() {
        return labelDepartContenir;
    }

    public void setLabelDepartContenir(Departement labelDepartContenir) {
        this.labelDepartContenir = labelDepartContenir;
    }

    public Matiere getCodeMat() {
        return codeMat;
    }

    public void setCodeMat(Matiere codeMat) {
        this.codeMat = codeMat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeEns != null ? codeEns.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enseignant)) {
            return false;
        }
        Enseignant other = (Enseignant) object;
        if ((this.codeEns == null && other.codeEns != null) || (this.codeEns != null && !this.codeEns.equals(other.codeEns))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.academie.entities.Enseignant[ codeEns=" + codeEns + " ]";
    }
    
}
