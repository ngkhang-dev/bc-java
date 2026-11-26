package com.cybersoft.uniclub14.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.time.Instant;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

  @Value("${jwt.key}")
  private String jwtKey;

  public String generateToken(String data) {
    SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtKey));

    // Approach 1
    // Date now = new Date();
    // Date expirationAt = new Date(now.getTime() + (1 * 60 *60 * 1000));

    // Approach 2
    Date expirationAt = Date.from(Instant.now().plusSeconds(8 * 60 * 60));

    return Jwts.builder().expiration(expirationAt).subject(data).signWith(secretKey).compact();
  }

  public String decodeToken(String token) {
    SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtKey));

    return Jwts.parser()
        .verifyWith(secretKey)
        .build()
        .parseSignedClaims(token)
        .getPayload()
        .getSubject();
  }
}
