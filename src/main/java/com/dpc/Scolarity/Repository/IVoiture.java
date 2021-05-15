package com.dpc.Scolarity.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dpc.Scolarity.Domain.PaysFabriquant;
import com.dpc.Scolarity.Domain.Utilisateur;
import com.dpc.Scolarity.Domain.Voiture;


public interface IVoiture extends JpaRepository<Voiture, Long> {

	List <Voiture> findByPayfabriquant(PaysFabriquant payfabriquant);

	
//	@Query(nativeQuery=true,value="select v.nom from voiture v INNER JOIN pays_fabriquant p ON p.id = v.payfabri_id where p.nom='nom'")
	//	  public List<Voiture> getvoitureByPaysFabriquant(@Param("nom") String nom);

	
}
