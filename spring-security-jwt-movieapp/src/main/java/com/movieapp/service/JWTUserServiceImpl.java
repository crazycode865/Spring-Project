/**
 * @Author:Awadhesh Date:04-05-2022
 * Time:22:12
 * Project Name:spring-boot-rest
 */
package com.movieapp.service;

import com.movieapp.model.JWTUser;
import com.movieapp.repository.JWTUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class JWTUserServiceImpl implements UserDetailsService {
    @Autowired
    private JWTUserRepository jwtUserRepository;
    public void addUser(JWTUser user){
        jwtUserRepository.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JWTUser user = jwtUserRepository.findByUsername(username);
        if (user==null)
            throw new UsernameNotFoundException("Invalid username");
        List<GrantedAuthority> authorities = Arrays.asList(
                new SimpleGrantedAuthority("ADMIN"),
                new SimpleGrantedAuthority("USER"));
        UserDetails userDetails = new User(user.getUsername(),user.getPassword(),authorities);
        return userDetails;
    }
}
