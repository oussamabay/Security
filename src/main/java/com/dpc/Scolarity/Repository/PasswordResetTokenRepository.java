package com.dpc.Scolarity.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dpc.Scolarity.Domain.PasswordResetToken;
import com.dpc.Scolarity.Domain.Utilisateur;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
	
	PasswordResetToken findByEmailEncrypted(String emailEncrypted);
	List<PasswordResetToken>  findByPasswordEncrypted(String passwordEncrypted);
List<	PasswordResetToken > findByUtilisateur(Utilisateur utilisateur);

}
