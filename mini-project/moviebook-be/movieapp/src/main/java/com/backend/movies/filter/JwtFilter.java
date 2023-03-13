package com.backend.movies.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // get authorization header from request object
        String authHeader = request.getHeader("authorization");
        // if authHeader is null || not bearer type : throw exception
        // else : verify the token, process request/dont process the request
        if(authHeader==null || !authHeader.startsWith("Bearer") ){
            throw new ServletException("Token missing");
        }
        else{ // authHeader existing + it has Bearer token
            // authHeader: Bearer_xxxxxxxxxxx.xxxxxxx.xxxxxxx
            String token = authHeader.substring(7); // Bearer abcd.xyz.mnop ->  abcd.xyz.mnop
            Claims claims=Jwts.parser().setSigningKey("mysecretkey").parseClaimsJws(token).getBody();
            // above parsing throws exception if parsing fails ( token invalid / key invalid )
            System.out.println("claims : " + claims);
            // attach emailid to request
            request.setAttribute("current_user_emailid",claims.get("user_email"));
            request.setAttribute("current_user_role",claims.get("user_role"));
            filterChain.doFilter(request,response); // forwarding
        }
    }
}




