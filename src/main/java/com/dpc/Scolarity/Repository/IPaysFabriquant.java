package com.dpc.Scolarity.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dpc.Scolarity.Domain.PaysFabriquant;
import com.dpc.Scolarity.Domain.Voiture;


public interface IPaysFabriquant extends JpaRepository<PaysFabriquant, Long> {
	
	PaysFabriquant findByNom(String nom);

}
