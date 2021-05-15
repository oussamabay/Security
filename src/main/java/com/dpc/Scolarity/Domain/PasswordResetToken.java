package com.dpc.Scolarity.Domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class PasswordResetToken {
private static final int EXPIRATION = 60 * 24;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String token;
	@OneToOne(targetEntity = Utilisateur.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id")
	private Utilisateur utilisateur;
	private String passwordEncrypted ;
	private String emailEncrypted; 
	private Date expiryDate;
}
