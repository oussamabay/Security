package com.dpc.Scolarity.service.implementation;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import com.dpc.Scolarity.Domain.PasswordResetToken;

import javax.crypto.NoSuchPaddingException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.dpc.Scolarity.Domain.Message;
import com.dpc.Scolarity.Domain.Utilisateur;
import com.dpc.Scolarity.Repository.IMessage;
import com.dpc.Scolarity.Repository.IUtilisateur;
import com.dpc.Scolarity.Repository.PasswordResetTokenRepository;

@Service
public class MailServiceImp {
	
	
	
	
	@Autowired
	IMessage msgrepos ; 
	
	 @Autowired
	    JavaMailSender mailSender;
	
	 @Autowired
	    private IUtilisateur userrepo;
	 @Autowired 
	 PasswordResetTokenRepository passresetrepositry;
	public void EnvoyerEmailAddUser(Utilisateur user ) {
		   MimeMessage mimeMessage = mailSender.createMimeMessage();  
	        try {
	String username=user.getUsername();
	            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

	            mimeMessageHelper.setSubject("Nouveau Compte Utilisateur SColarity ");
	            mimeMessageHelper.setFrom("scolarity.dpc@gmail.com");
	            mimeMessageHelper.setTo(user.getEmail());
      
             String content = "Bonjour Mr(Mme):" + user.getNom() +" "+ user.getPrenom()
            +" "+ "Bienvenue Dans la platforme SColarity: \n "
			   +"<br><br>Votre Login est : " +user.getUsername() + "\n" 
			   +"<br><br>Votre Mot de passe est : " +user.getPassword()+ "\n"+" <br><br> Cordialement.";
			   System.out.println(content);

             mimeMessageHelper.setText(content);
             // Add a resource as an attachment
             mimeMessageHelper.setText("<html><body><p>" + content + "</p><img src='cid:http://207.180.211.156/logodpc.bmp'></body></html>", true);
           
         	Message msg = new Message();
 			msg.setDate_message(new Date(System.currentTimeMillis()));
 			msg.setArchiver(false);
 			msg.setMessage(content);
 			msg.setSujet(user.getNom());
 			msg.setReciever(user);
 			msgrepos.save(msg);
 			
	 
	            mailSender.send(mimeMessageHelper.getMimeMessage());
	        } catch (MessagingException x) {
	            x.printStackTrace();
	        }
		
	}
	
	
	
	
	
	
    public Map<String, Boolean> RenisialiserMotdepasse(String emailcrypter ) throws NoSuchAlgorithmException, NoSuchPaddingException {
		   MimeMessage mimeMessage = mailSender.createMimeMessage();  
		   Map<String, Boolean> success = new TreeMap<String, Boolean>();
		   List<PasswordResetToken> listpasswordResetToken=new ArrayList<>();
	        try {
	            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	            org.springframework.security.crypto.password.PasswordEncoder passwordEncorder
	            = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
	           String email = passwordEncorder.encode(emailcrypter);
	           PasswordResetToken tosave= new PasswordResetToken();
	           Utilisateur useertosave= new Utilisateur();
	           useertosave=this.userrepo.findByEmail(emailcrypter);
	           if(useertosave!=null)
	           {
	        	   tosave.setUtilisateur(useertosave);
	        	   tosave.setEmailEncrypted(email);
	        	   this.passresetrepositry.save(tosave); 
	        	   success.put("response", true);

		            mimeMessageHelper.setSubject("RÃ©initialiser le mot de passe SColarity ");
		            mimeMessageHelper.setFrom("scolarity.dpc@gmail.com");
		            mimeMessageHelper.setTo(emailcrypter);
		            String content = "Bonjour <br> Nous avons cru comprendre que vous vouliez rÃ©initialiser votre mot de passe. Cliquez sur le lien ci-dessous "
	                		+ "et vous serez redirigÃ© vers un site sÃ©curisÃ© oÃ¹ vous pourrez dÃ©finir un nouveau mot de passe.<br>"
	                		+ "<a href=\"http://localhost:4200/login/mpoublier/"+email+"\">cliquez ici</a><br>Cordiallement";
            		

	                mimeMessageHelper.setText(content);
	                // Add a resource as an attachment
	                mimeMessageHelper.setText("<html><body><p>" + content + "</p><img src='cid:http://207.180.211.156/logodpc.bmp'></body></html>", true);
	              
		            
		 
		            mailSender.send(mimeMessageHelper.getMimeMessage());
	        	   
	           }
	           else {
	        	   
	        	   success.put("response", false); 
	           }
	           System.out.println("***************************************************email crypteeeee");
               System.out.println(email);
             
	/*
	 * listpasswordResetToken=this.passresetrepositry.findByEmailEncrypted(email);
	 * 
	 * for(PasswordResetToken p :listpasswordResetToken) {
	 * 
	 * String a = p.getEmailEncrypted();
	 * 
	 * 
	 * if( ! passwordEncorder.matches(emailcrypter, a)) {
	 * 
	 * System.out.println("email non  egaux"); } else { success.put("response",
	 * true); System.out.println(p.getUtilisateur().getEmail());
	 * System.out.println(a); System.out.println("email egaux"); }
	 * 
	 * }
	 */
              



	           
	        } catch (MessagingException x) {
	            x.printStackTrace();
	        }
			return success;
		
	}
	
	
	
	
	

	
}
