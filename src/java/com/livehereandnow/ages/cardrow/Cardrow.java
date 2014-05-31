/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livehereandnow.ages.cardrow;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mark
 */
@Entity
@Table(name = "CARDROW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cardrow.findAll", query = "SELECT c FROM Cardrow c"),
    @NamedQuery(name = "Cardrow.findById", query = "SELECT c FROM Cardrow c WHERE c.id = :id"),
    @NamedQuery(name = "Cardrow.findByF1", query = "SELECT c FROM Cardrow c WHERE c.f1 = :f1"),
    @NamedQuery(name = "Cardrow.findByF2", query = "SELECT c FROM Cardrow c WHERE c.f2 = :f2"),
    @NamedQuery(name = "Cardrow.findByF3", query = "SELECT c FROM Cardrow c WHERE c.f3 = :f3"),
    @NamedQuery(name = "Cardrow.findByF4", query = "SELECT c FROM Cardrow c WHERE c.f4 = :f4"),
    @NamedQuery(name = "Cardrow.findByF5", query = "SELECT c FROM Cardrow c WHERE c.f5 = :f5")})
public class Cardrow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "F1")
    private String f1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "F2")
    private String f2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "F3")
    private String f3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "F4")
    private String f4;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "F5")
    private String f5;

    public Cardrow() {
    }

    public Cardrow(Integer id) {
        this.id = id;
    }

    public Cardrow(Integer id, String f1, String f2, String f3, String f4, String f5) {
        this.id = id;
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
        this.f5 = f5;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    public String getF3() {
        return f3;
    }

    public void setF3(String f3) {
        this.f3 = f3;
    }

    public String getF4() {
        return f4;
    }

    public void setF4(String f4) {
        this.f4 = f4;
    }

    public String getF5() {
        return f5;
    }

    public void setF5(String f5) {
        this.f5 = f5;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cardrow)) {
            return false;
        }
        Cardrow other = (Cardrow) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livehereandnow.ages.Cardrow[ id=" + id + " ]";
    }
    
}
