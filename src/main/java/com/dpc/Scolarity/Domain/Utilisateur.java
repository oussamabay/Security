package com.dpc.Scolarity.Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * @author slim
 *
 */

@Entity
public class Utilisateur implements UserDetails, Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private    Long id ;
	private String  nom;
	private String nomEntreprise ;
	private Long codeTVA ;
	private String adresse ; 
	
	public String getNomEntreprise() {
		return nomEntreprise;
	}
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	public Long getCodeTVA() {
		return codeTVA;
	}
	public void setCodeTVA(Long codeTVA) {
		this.codeTVA = codeTVA;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	private String prenom ;
	//private String remarque ;
	@Temporal(TemporalType.DATE)
	private Date date_naissance ;
	//private String sexe ;
	//private String SituationFamiliale ;
	private String Photo ;
	private Long Cin ;
	//private Boolean parain ;
	@Column(name = "last_password_reset_date")
	private Date lastPasswordResetDate;
	@ManyToOne
	private Authority authorities;
	@Column(name = "phone_number")
	private String telephone;
	//private Boolean archiver ;
	//@Temporal(TemporalType.DATE)
	//private Date datedembauche ;
	///private Long nbrheures;
	//private Long anciennete;
	

	
	
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	@Column(name = "enabled")
	private boolean enabled;
	@Column(name = "username", unique = true)
	private String username;
	private String password;
	public void setPassword(String password) {
		this.password = password;
	}
	
	private String email ;
	//private String num_passport ;
	@Column(name = "profil")
	private String profil;
	
	

	 
	 
	 
	 
	 
	 
	


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	public Long getCin() {
		return Cin;
	}
	public void setCin(Long cin) {
		this.Cin = cin;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Utilisateur() {
		super();
	}
	

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<Authority> auth = new ArrayList<Authority>();
		auth.add(authorities);
		return auth;
	}
	public void setAuthorities(Authority authorities) {
		this.authorities = authorities;
	}
	
	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}
	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}


	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	

	

	
	

}
