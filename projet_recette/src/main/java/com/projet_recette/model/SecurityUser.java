/*

package com.projet_recette.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.projet_recette.entities.Utilisateur;



public class SecurityUser implements UserDetails {

	Utilisateur user;
	
	public SecurityUser( Utilisateur user) {
		this.user = user;
	}
	
// role = "admin,user"	
// newRole = ["admin","user"]
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.stream(user
				.getRole()
				.split(","))
				.map(SimpleGrantedAuthority::new)
				.toList();
	}

	@Override
	public String getPassword() {
		return user.getMdp();
	}

	@Override
	public String getUsername() {
		return user.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}

*/
