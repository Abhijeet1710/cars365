package com.cars365.AuthService.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

@Service
public class JwtUtilsService {
    private static final String SECRET_KEY = "sdascajsvcajscasc46as4cascascascascasccccdvfbdzscsac";

    public String generateToken(String username) {
        HashMap<String, String> claims = new HashMap<>();
        claims.put("username", username);

        return Jwts.builder()
                .setSubject(username)
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(getSecretKey())
                .compact();
    }
    
    public boolean validateToken(String token, String username) {
        String tokenUsername = extractUsername(token);
        try {
            return (username.equals(tokenUsername) && !isTokenExpired(token));
        } catch (ExpiredJwtException e) {
            return false;
        }
    }
    
    private boolean isTokenExpired(String token) {
        Date expirationDate = extractClaims(token).getExpiration();
        return expirationDate.before(new Date());
    }
    
    public String extractUsername(String token) {
        return (String) extractClaims(token).get("username");
    }

    private Key getSecretKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    private Claims extractClaims(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        System.out.println("Extracted Claims: " + claims); // Add this line
        return claims;
    }

}
