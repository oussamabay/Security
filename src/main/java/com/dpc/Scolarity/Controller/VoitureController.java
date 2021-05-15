package com.dpc.Scolarity.Controller;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dpc.Scolarity.Domain.PaysFabriquant;
import com.dpc.Scolarity.Domain.Utilisateur;
import com.dpc.Scolarity.Domain.Voiture;
import com.dpc.Scolarity.Repository.IPaysFabriquant;
import com.dpc.Scolarity.Repository.IUtilisateur;
import com.dpc.Scolarity.Repository.IVoiture;
import com.dpc.Scolarity.service.implementation.Voitureervice;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/voiture", produces = MediaType.APPLICATION_JSON_VALUE)


public class VoitureController {
	@Autowired
	IPaysFabriquant payrepos; 
	@Autowired
	IVoiture voiturerepos ;
	@Autowired
	Voitureervice voitureservice ; 
	@Autowired
	IUtilisateur userrepos ; 
	
	
	 
	  @RequestMapping(value = "/nombypays", method = RequestMethod.GET) public
	  Collection<Voiture> getvoitureByPaysFabriquant( String nom) {
	  
	  return voitureservice.findAllPayFabriquant(nom); }
	 
		//**************Ajout Pay ***************
		@RequestMapping(value = "/addVoiture", method = RequestMethod.POST)
		//@PreAuthorize("hasRole('ADMIN')")
		public  @ResponseBody Map<String, Boolean> addPaufabriquant(Model model ,String username, @RequestBody Voiture voiture ) {
			Boolean response;
			try {
				Utilisateur usercooncted = this.userrepos.findByUsername(username);
				
				voiturerepos.save(voiture);

              Map<String, Boolean> success = new TreeMap<String, Boolean>();
				success.put("response", true);
				//email=user.getEmail();
				//this.mailservice.EnvoyerEmailAddUser(user);
				return success;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				e.printStackTrace();
				Map<String, Boolean> echec = new TreeMap<String, Boolean>();
				echec.put("response", false);
				return echec;
			}}
	 

}
