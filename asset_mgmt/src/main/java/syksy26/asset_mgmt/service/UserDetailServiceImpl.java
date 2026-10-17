package syksy26.asset_mgmt.service;


import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import syksy26.asset_mgmt.domain.User;
import syksy26.asset_mgmt.domain.UserRepository;


// Spring security authentication and user authorize 

@Service
public class UserDetailServiceImpl implements UserDetailsService  {

	UserRepository repository;
	
	public UserDetailServiceImpl(UserRepository appUserRepository) {
			this.repository = appUserRepository; 
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
    	User curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPassword(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }   
 

  

}  

	

