/*

package com.projet_recette.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

	private final JwtEncoder encoder;
	
	public TokenService(JwtEncoder encoder) {
		this.encoder = encoder;
	}
	
	public String generateToken(Authentication authentication) {
		Instant now = Instant.now(); // date courante
		
		ArrayList<String> scope = new ArrayList<>();
		Collection auth = authentication.getAuthorities();
		for(Object o: auth) { // récupérer les roles de l'user en cours
			scope.add(o.toString());
		}
		
		JwtClaimsSet claims = JwtClaimsSet.builder()
			.issuer("self") // emetteur 
			.issuedAt(now) // date d'emission du token
			.expiresAt(now.plus(1, ChronoUnit.HOURS)) // date d'expiration du token
			.subject(authentication.getName()) // sujet
			.claim("roles", scope) // rôles
			.build(); // construit les claims
		
		JwtEncoderParameters encoderParameters = JwtEncoderParameters // construit les param de l'encodeur
													.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims);
		
		return this.encoder.encode(encoderParameters).getTokenValue(); // encode les params
			
	}
}

*/
