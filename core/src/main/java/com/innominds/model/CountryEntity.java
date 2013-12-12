package com.innominds.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;



/**
 * CountryEntity entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "country")
public class CountryEntity implements java.io.Serializable {

    // Fields

    /**
     * 
     */
    private static final long serialVersionUID = -8337503164740572963L;
    private String countryId;
    private String countryName;
    private String countryDesc;
    private String countryCode;

    // Constructors

    /** default constructor */
    public CountryEntity() {
    }

    /** minimal constructor */
    public CountryEntity(String countryId) {
        this.countryId = countryId;
    }

    // Property accessors
    @Id
    @Column(name = "country_id", unique = false, nullable = false, insertable = true, updatable = true, length = 36)
    public String getCountryId() {
        return this.countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Column(name = "country_name", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Column(name = "country_desc", unique = false, nullable = true, insertable = true, updatable = true)
    public String getCountryDesc() {
        return this.countryDesc;
    }

    public void setCountryDesc(String countryDesc) {
        this.countryDesc = countryDesc;
    }

    
    @PrePersist
    public void generateId() {
        if (countryId == null) {
            setCountryId("001");
        }
    }

    @Column(name = "country_code", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}