/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.academie.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ASUS TUF A17
 */
@Entity
@Table(name = "evaluation", catalog = "academie", schema = "")
@NamedQueries({
    @NamedQuery(name = "Evaluation.findAll", query = "SELECT e FROM Evaluation e"),
    @NamedQuery(name = "Evaluation.findByCodeEtud", query = "SELECT e FROM Evaluation e WHERE e.evaluationPK.codeEtud = :codeEtud"),
    @NamedQuery(name = "Evaluation.findByCodeMat", query = "SELECT e FROM Evaluation e WHERE e.evaluationPK.codeMat = :codeMat"),
    @NamedQuery(name = "Evaluation.findByNote", query = "SELECT e FROM Evaluation e WHERE e.note = :note")})
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EvaluationPK evaluationPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "note")
    private Double note;
	
	  @JoinColumn(name = "code_etud", referencedColumnName = "code_etud",
	  insertable = false, updatable = false)
	  
	  @ManyToOne(optional = false) private Etudiant etudiant;
	  
	  @JoinColumn(name = "code_mat", referencedColumnName = "code_mat", insertable
	  = false, updatable = false)
	  
	  @ManyToOne(optional = false)
	 
    private Matiere matiere;

    public Evaluation() {
    }

    public Evaluation(EvaluationPK evaluationPK) {
        this.evaluationPK = evaluationPK;
    }

    public Evaluation(String codeEtud, String codeMat) {
        this.evaluationPK = new EvaluationPK(codeEtud, codeMat);
    }

    public EvaluationPK getEvaluationPK() {
        return evaluationPK;
    }

    public void setEvaluationPK(EvaluationPK evaluationPK) {
        this.evaluationPK = evaluationPK;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
       this.etudiant = etudiant;
   }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluationPK != null ? evaluationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.evaluationPK == null && other.evaluationPK != null) || (this.evaluationPK != null && !this.evaluationPK.equals(other.evaluationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.academie.entities.Evaluation[ evaluationPK=" + evaluationPK + " ]";
    }
    
}
