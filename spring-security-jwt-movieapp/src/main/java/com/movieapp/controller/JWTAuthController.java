/**
 * @Author:Awadhesh Date:04-05-2022
 * Time:22:22
 * Project Name:spring-boot-rest
 */
package com.movieapp.controller;

import com.movieapp.model.JWTUser;
import com.movieapp.service.JWTUserServiceImpl;
import com.movieapp.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWTAuthController {
    @Autowired
    JWTUserServiceImpl jwtUserService;
    @Autowired
    public PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody JWTUser user){
        String username = user.getUsername();
        String password = passwordEncoder.encode(user.getPassword());
        JWTUser jwtUser = new JWTUser(username,password);
        jwtUserService.addUser(jwtUser);
        return  ResponseEntity.ok("User Added");
    }
    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody JWTUser user){
        authenticate(user.getUsername(),user.getPassword());
        UserDetails details = jwtUserService.loadUserByUsername(user.getUsername());
        String jwtToken = jwtTokenUtil.generateToken(details);
        return ResponseEntity.ok(jwtToken);
    }
    private void authenticate(String username,String password){
        try {
            UsernamePasswordAuthenticationToken authenticationToken=
                    new UsernamePasswordAuthenticationToken(username,password);
            authenticationManager.authenticate(authenticationToken);
        }catch (BadCredentialsException e){
            System.out.println("Invalid credential!!!");
        }catch (DisabledException e){
            System.out.println("User Disabled");
        }
    }
    @GetMapping("/greet")
    public String greet(){
        return "Welcome to the world of JWT Security";
    }
}
