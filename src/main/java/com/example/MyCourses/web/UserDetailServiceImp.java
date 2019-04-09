package com.example.MyCourses.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.MyCourses.domain.User;
import com.example.MyCourses.domain.UserRepository;

@Service
public class UserDetailServiceImp implements UserDetailsService {

	private final UserRepository urepository;

	@Autowired
	public UserDetailServiceImp(UserRepository userRepository) {
		this.urepository = userRepository;
	}

	// getting the current user and checking his/hers user role
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User currentUser = urepository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username,
				currentUser.getPasswordHash(), AuthorityUtils.createAuthorityList(currentUser.getRole()));
		return user;
	}

}
