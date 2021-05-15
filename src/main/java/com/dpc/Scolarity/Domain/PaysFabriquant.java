package com.dpc.Scolarity.Domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class PaysFabriquant implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private    Long id ;
	private String  nom;
	
	
}
