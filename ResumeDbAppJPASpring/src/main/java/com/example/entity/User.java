/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")}
)

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer alma;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Lob
    @Column(name = "profile_Description")
    private String profileDescription;
    @Column(name = "address")
    private String address;
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "password")
    private String password;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserSkill> userSkillList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<EmploymentHistory> employmentHistoryList;
    @JoinColumn(name = "nationality_id", referencedColumnName = "id")
    @ManyToOne
    private Country nationality;
    @JoinColumn(name = "birthplace_id", referencedColumnName = "id")
    @ManyToOne
    private Country birthPlace;

    public User() {
    }

    public User(Integer id) {
        this.alma = id;
    }

    public User(Integer id, String name, String surname, String email, String phone) {
        this.alma = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return alma;
    }

    public void setId(Integer id) {
        this.alma = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Country getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(Country birthPlace) {
        this.birthPlace = birthPlace;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserSkill> getUserSkillList() {
        return userSkillList;
    }

    public void setUserSkillList(List<UserSkill> userSkillList) {
        this.userSkillList = userSkillList;
    }

    public List<EmploymentHistory> getEmploymentHistoryList() {
        return employmentHistoryList;
    }

    public void setEmploymentHistoryList(List<EmploymentHistory> employmentHistoryList) {
        this.employmentHistoryList = employmentHistoryList;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alma != null ? alma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.alma == null && other.alma != null) || (this.alma != null && !this.alma.equals(other.alma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.User[ id=" + alma + ",name="+name+" surname="+surname+" email="+email+" ]";
    }
    
}
