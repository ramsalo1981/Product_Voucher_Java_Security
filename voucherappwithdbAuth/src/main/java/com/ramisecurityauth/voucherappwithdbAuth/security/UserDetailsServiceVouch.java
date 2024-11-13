package com.ramisecurityauth.voucherappwithdbAuth.security;

import com.ramisecurityauth.voucherappwithdbAuth.model.User;
import com.ramisecurityauth.voucherappwithdbAuth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceVouch implements UserDetailsService {
    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("User not Found " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),user.getRoles());
    }
}
