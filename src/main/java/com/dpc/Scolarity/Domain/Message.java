package com.dpc.Scolarity.Domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	
	private Boolean archiver ;
	@Temporal(TemporalType.DATE)

	private Date date_message ;
	
	private String message ;
	private String sujet ;
	@ManyToOne
	private Utilisateur sender ;
	@ManyToOne
	private Utilisateur reciever ;
}
