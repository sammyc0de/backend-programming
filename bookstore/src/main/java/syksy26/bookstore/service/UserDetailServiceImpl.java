package syksy26.bookstore.service;


import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import syksy26.bookstore.domain.AppUser;
import syksy26.bookstore.domain.AppUserRepository;

/**
 * Class for spring security authentication and user authorize 
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService  {

	AppUserRepository repository;
	
	// Constructor Injection
	public UserDetailServiceImpl(AppUserRepository appUserRepository) {
			this.repository = appUserRepository; 
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
    	AppUser curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }   
 

  

}  

	

