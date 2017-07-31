/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author reversidesoftwaresolution
 */
@Entity
@Table(name = "Candidates")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidates.findAll", query = "SELECT c FROM Candidates c")
    , @NamedQuery(name = "Candidates.findByUserId", query = "SELECT c FROM Candidates c WHERE c.userId = :userId")
    , @NamedQuery(name = "Candidates.findByFirstName", query = "SELECT c FROM Candidates c WHERE c.firstName = :firstName")
    , @NamedQuery(name = "Candidates.findByLastName", query = "SELECT c FROM Candidates c WHERE c.lastName = :lastName")
    , @NamedQuery(name = "Candidates.findByDivision", query = "SELECT c FROM Candidates c WHERE c.division = :division")})
public class Candidates implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "first_Name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_Name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "division")
    private String division;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userFk")
    private Collection<Credentials> credentialsCollection;

    public Candidates() {
    }

    public Candidates(Integer userId) {
        this.userId = userId;
    }

    public Candidates(Integer userId, String firstName, String lastName, String division) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.division = division;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @XmlTransient
    public Collection<Credentials> getCredentialsCollection() {
        return credentialsCollection;
    }

    public void setCredentialsCollection(Collection<Credentials> credentialsCollection) {
        this.credentialsCollection = credentialsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidates)) {
            return false;
        }
        Candidates other = (Candidates) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.Candidates[ userId=" + userId + " ]";
    }
    
}
