/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.academie.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ASUS TUF A17
 */
@Embeddable
public class EvaluationPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "code_etud")
    private String codeEtud;
    @Basic(optional = false)
    @Column(name = "code_mat")
    private String codeMat;

    public EvaluationPK() {
    }

    public EvaluationPK(String codeEtud, String codeMat) {
        this.codeEtud = codeEtud;
        this.codeMat = codeMat;
    }

    public String getCodeEtud() {
        return codeEtud;
    }

    public void setCodeEtud(String codeEtud) {
        this.codeEtud = codeEtud;
    }

    public String getCodeMat() {
        return codeMat;
    }

    public void setCodeMat(String codeMat) {
        this.codeMat = codeMat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeEtud != null ? codeEtud.hashCode() : 0);
        hash += (codeMat != null ? codeMat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluationPK)) {
            return false;
        }
        EvaluationPK other = (EvaluationPK) object;
        if ((this.codeEtud == null && other.codeEtud != null) || (this.codeEtud != null && !this.codeEtud.equals(other.codeEtud))) {
            return false;
        }
        if ((this.codeMat == null && other.codeMat != null) || (this.codeMat != null && !this.codeMat.equals(other.codeMat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.academie.entities.EvaluationPK[ codeEtud=" + codeEtud + ", codeMat=" + codeMat + " ]";
    }
    
}
