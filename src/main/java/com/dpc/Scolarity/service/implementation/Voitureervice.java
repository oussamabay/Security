package com.dpc.Scolarity.service.implementation;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpc.ThirstSecurityAppApplication;
import com.dpc.Scolarity.Domain.PaysFabriquant;
import com.dpc.Scolarity.Domain.Utilisateur;
import com.dpc.Scolarity.Domain.Voiture;
import com.dpc.Scolarity.Repository.IPaysFabriquant;
import com.dpc.Scolarity.Repository.IVoiture;

@Service
public class Voitureervice {
	@Autowired
	IPaysFabriquant payrepos ; 
	@Autowired
	IVoiture voiturerepos ; 
	


	
	
	  
	  public Collection<Voiture> findAllPayFabriquant(String nom) {
	  
	  PaysFabriquant payfabriquant = new PaysFabriquant();
	  payfabriquant=this.payrepos.findByNom(nom); return
	  this.voiturerepos.findByPayfabriquant(payfabriquant);
	  
	  }
	 
}
