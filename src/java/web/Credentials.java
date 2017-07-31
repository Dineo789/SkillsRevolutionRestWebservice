/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author reversidesoftwaresolution
 */
@Entity
@Table(name = "Credentials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credentials.findAll", query = "SELECT c FROM Credentials c")
    , @NamedQuery(name = "Credentials.findByCredId", query = "SELECT c FROM Credentials c WHERE c.credId = :credId")
    , @NamedQuery(name = "Credentials.findByEmail", query = "SELECT c FROM Credentials c WHERE c.email = :email")})
public class Credentials implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cred_id")
    private Integer credId;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "Email")
    private String email;
    @JoinColumn(name = "user_fk", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private Candidates userFk;

    public Credentials() {
    }

    public Credentials(Integer credId) {
        this.credId = credId;
    }

    public Integer getCredId() {
        return credId;
    }

    public void setCredId(Integer credId) {
        this.credId = credId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Candidates getUserFk() {
        return userFk;
    }

    public void setUserFk(Candidates userFk) {
        this.userFk = userFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (credId != null ? credId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credentials)) {
            return false;
        }
        Credentials other = (Credentials) object;
        if ((this.credId == null && other.credId != null) || (this.credId != null && !this.credId.equals(other.credId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.Credentials[ credId=" + credId + " ]";
    }
    
}
