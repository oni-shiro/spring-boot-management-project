package com.sinchan.hibernateproject.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private  JWTTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

      /*filter works only when user already authorised and try to access secured endpoints*/

        // requestToken got auth token from request header
        final String requestToken = request.getHeader("Authorization");

        //log that request token
        // bearer 233355 token
        System.out.println("requestToken   " + requestToken );

        //set username and token
        String username = null;
        String token = null;


        //get username from token
        if(requestToken != null && requestToken.startsWith("Bearer")){
            token = requestToken.substring(7);
            try {
                username = this.jwtTokenHelper.getUserNameFromToken(token);
            } catch (IllegalArgumentException e){
                System.out.println("unable to get JWT token..");
            } catch (ExpiredJwtException e){
                System.out.println("token is already expired..");
            } catch (MalformedJwtException e){
                System.out.println("invalid JWT exception");
            }
        } else {
            System.out.println("JWT token does not begin with bearer....");
        }

        //once we get the username now we validate token
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){

            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            if(this.jwtTokenHelper.validateToken(token, userDetails)){

                //token is ok now need to authentication
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities()
                        );

                authToken
                        .setDetails(new WebAuthenticationDetailsSource()
                                .buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authToken);

            } else {
                System.out.println("invalid JWT token.........");
            }
        } else {
            System.out.println("Username is null or SecurityContext is not null");
        }

        filterChain.doFilter(request, response);

    }
}
