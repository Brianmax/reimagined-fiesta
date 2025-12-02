package com.example.demo.service.impl;

import com.example.demo.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

public class JwtServiceImpl implements JwtService {
    @Override
    public String generarToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS256, getSignKey())
                .compact();
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        Claims claims = extractClaims(token);
        String username = extractUsername(token);
        Date expiration = claims.getExpiration();
        return (username.equals(userDetails.getUsername()) && !expiration.before(new Date(System.currentTimeMillis())));
    }

    @Override
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }
    private Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey("")
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignKey() {
        byte[] key = Base64.getDecoder().decode("RVHrIphEwxczz+FQyxwibYcDj701rULKsYejSFDt3m4=");
        return Keys.hmacShaKeyFor(key);
    }
}
