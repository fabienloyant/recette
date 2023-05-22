/*

package com.projet_recette.configuration;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import com.projet_recette.service.JpaDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConf {
	
	@Value("${jwt.secretKey}")
	private String secretKey;
	
	private JpaDetailsService jpaDetailsService;
	
	public SecurityConf(JpaDetailsService service) {
		this.jpaDetailsService = service;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http // configuration de nos filtres de sécurité
				.userDetailsService(jpaDetailsService)
				.authorizeHttpRequests(auth -> auth // permet de configurer les requêtes autorisées
						.requestMatchers("/auth/**").permitAll() // pour la route /login pas besoin d'être connecté
						.anyRequest().authenticated() // pour les autres routes, connection obligatoire
						)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // configurer a gestion des sessions
				.csrf(AbstractHttpConfigurer::disable)// désactive la protection CSRF
				.oauth2ResourceServer(oauth -> oauth // configurer le server de ressource
						.jwt(jwtConfigurer -> jwtConfigurer // configurer le jeton JWT
								.jwtAuthenticationConverter(jwtAuthenticationConverter()))) // configurer le convertisseur d'auth JWT
				.httpBasic(Customizer.withDefaults()) // configurer l'auth de base
				.build();
	}
	
	@Bean
	public JwtAuthenticationConverter jwtAuthenticationConverter() { // ajouter les données du jwt à l'objet Authentification
		JwtAuthenticationConverter converter = new JwtAuthenticationConverter(); // créer le convertisseur d'authentification
		converter.setJwtGrantedAuthoritiesConverter(jwt -> { // configurer les authorités du convertisseur
			List<String> authorities = jwt.getClaimAsStringList("roles"); // on vient chercher l'attribut roles dans le token 
			if(authorities == null) { // si les roles sont vide
				authorities = Collections.emptyList();
			}
			return authorities.stream() // on retourne les Authorities
					.map(SimpleGrantedAuthority::new)
					.collect(Collectors.toList());
		});
		return converter; // on retourne le converter
	}
	
	@Bean 
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // retourne une instance de l'objet BcryptPasswordEncoder
	}
	
	@Bean
	public JwtEncoder jwtEncoder() {
		return new NimbusJwtEncoder(new ImmutableSecret<>(secretKey.getBytes())); // encoder le token
	}
	
	@Bean
	public JwtDecoder jwtDecoder() {
		byte[] bytes = secretKey.getBytes(); // récupérer la clé secrète
		SecretKeySpec originalKey = new SecretKeySpec(bytes, 0, bytes.length, "RAS"); // créer une clé secrète
		return NimbusJwtDecoder.withSecretKey(originalKey).macAlgorithm(MacAlgorithm.HS256).build(); // décode le jeton avec le bon algo
		
	}
}

*/

