package com.movieapp.config;

import com.movieapp.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
@Autowired
JwtTokenUtil jwtTokenUtil;
@Autowired
    UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String headerValue = request.getHeader("Authorization");

        String jwtToken = null;
        String username = null;
        if(headerValue!=null && headerValue.startsWith("Bearer")){
            jwtToken = headerValue.substring(7);
            username  = jwtTokenUtil.getUsernameFromToken(jwtToken);
        }else{
            logger.warn("Invalid Header");
        }
        if(username!=null && SecurityContextHolder.getContext()!=null) {
            UserDetails details = userDetailsService.loadUserByUsername(username);
            List<GrantedAuthority> authorities = Arrays.asList(
                    new SimpleGrantedAuthority("ADMIN"),
                    new SimpleGrantedAuthority("USER"));
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(details.getUsername(), details.getPassword(), authorities);
            authenticationToken.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request,response);


    }
}
