package com.rsvier.workshop2.mvc.model.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="account",catalog="workshop2")
public class Account  implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="poep", unique=true, nullable=false)
    private Long idAccount;
    @Column(name="naam", length=45)
    private String naam;
    @Column(name="wachtwoord", length=45)
    private String wachtwoord;
    @Column(name="accountStatus", length=45)
    private String accountStatus;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createDate", length=19)
    private Date createDate;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="account")
    private Set<Klant> klants = new HashSet<>(0);

    public Account() {
    }

    public Account(String naam, String wachtwoord, String accountStatus, Date createDate, Set<Klant> klants) {
       this.naam = naam;
       this.wachtwoord = wachtwoord;
       this.accountStatus = accountStatus;
       this.createDate = createDate;
       this.klants = klants;
    }
   
    public Long getIdAccount() {
        return this.idAccount;
    }
    
    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    
    public String getNaam() {
        return this.naam;
    }
    
    public void setNaam(String naam) {
        this.naam = naam;
    }

    
    public String getWachtwoord() {
        return this.wachtwoord;
    }
    
    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    
    
    public String getAccountStatus() {
        return this.accountStatus;
    }
    
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

   
    public Set<Klant> getKlants() {
        return this.klants;
    }
    
    public void setKlants(Set<Klant> klants) {
        this.klants = klants;
    }

    @Override
    public String toString() {
        return "Account{" + "idAccount=" + idAccount + ", naam=" + naam + ", wachtwoord=" + wachtwoord + ", accountStatus=" + accountStatus + ", createDate=" + createDate + ", klants=" + klants + '}';
    }

}


