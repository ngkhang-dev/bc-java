package com.cybersoft.uniclub14.filter;

import com.cybersoft.uniclub14.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

@Service
public class CustomTokenFilter extends OncePerRequestFilter {

  @Autowired private JwtUtils jwtUtils;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String headerAuthor = request.getHeader("Authorization");

    if (headerAuthor != null && headerAuthor.startsWith("Bearer ")) {
      String token = headerAuthor.substring(7);
      String data = jwtUtils.decodeToken(token);

      if (data != null) {
        SecurityContext securityContext = SecurityContextHolder.getContext();

        List<GrantedAuthority> list = new ArrayList<>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(data);
        list.add(authority);

        UsernamePasswordAuthenticationToken authentication =
            new UsernamePasswordAuthenticationToken("", "", list);
        securityContext.setAuthentication(authentication);
      }
    }

    filterChain.doFilter(request, response);
  }
}
