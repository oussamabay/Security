package com.dpc.Scolarity.Controller;

import java.sql.Date;
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
import com.dpc.Scolarity.Repository.IPaysFabriquant;
import com.dpc.Scolarity.Repository.IUtilisateur;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/pays", produces = MediaType.APPLICATION_JSON_VALUE)



public class PaysFabriquantController {
	
@Autowired
IUtilisateur userrepos ; 
@Autowired
IPaysFabriquant payrepos; 

	//@PreAuthorize("hasRole('Admi')")
		@RequestMapping(value = "/getall", method = RequestMethod.GET)
		public @ResponseBody List<PaysFabriquant> getallpays(Model model) {
			return payrepos.findAll();
		}
		
		  
		//**************Ajout Pay ***************
				@RequestMapping(value = "/addPaufabriquant", method = RequestMethod.POST)
				//@PreAuthorize("hasRole('ADMIN')")
				public  @ResponseBody Map<String, Boolean> addPaufabriquant(Model model ,String username, @RequestBody PaysFabriquant pay ) {
					Boolean response;
					try {
						Utilisateur usercooncted = this.userrepos.findByUsername(username);
						
						payrepos.save(pay);

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
