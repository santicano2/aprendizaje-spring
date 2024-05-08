package com.example.aprendizajespring.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.aprendizajespring.entities.UserRole;
import com.example.aprendizajespring.repositories.IUserRepository;

@Service("userService")
public class UserService implements UserDetailsService {

	private IUserRepository userRepository;

	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.example.aprendizajespring.entities.User user = userRepository
				.findByUsernameAndFetchUserRolesEagerly(username);
		return buildUser(user, buildGrantedAuthorities(user.getUserRoles()));
	}

	private User buildUser(com.example.aprendizajespring.entities.User user,
			List<GrantedAuthority> grantedAuthorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, // accountNonExpired,
																									// credentialsNonExpired,
																									// accountNonLocked,
				grantedAuthorities);
	}

	private List<GrantedAuthority> buildGrantedAuthorities(Set<UserRole> userRoles) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (UserRole userRole : userRoles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return new ArrayList<>(grantedAuthorities);
	}
}