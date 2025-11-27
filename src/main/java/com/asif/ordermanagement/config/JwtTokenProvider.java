package com.asif.ordermanagement.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {
    private final Key signingKey;
    private final long validityInMilliseconds;

    public JwtTokenProvider(@Value("${jwt.secret}") String secret, @Value("${jwt.expirationMs}") long validityInMilliseconds) {
        if (secret == null || secret.length() < 32) {
            throw new IllegalArgumentException("JWT secret key is missing or too short!");
        }
        this.signingKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
        this.validityInMilliseconds = validityInMilliseconds;

    }

    public String createToken(Integer userId, String role) {
        Map<String, Object> claim = new HashMap<>();
        claim.put("role", role);

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder().claims(claim).subject(String.valueOf(userId)).issuedAt(now).expiration(validity).signWith(signingKey).compact();
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().verifyWith((SecretKey) signingKey).build().parseSignedClaims(token);

            return !claims.getPayload().getExpiration().before(new Date());

        } catch (JwtException | IllegalArgumentException ex) {
            return false;
        }
    }

    public Integer getUserId(String token) {
        Claims claims = Jwts.parser().verifyWith((SecretKey) signingKey).build().parseSignedClaims(token).getPayload();

        return Integer.valueOf(claims.getSubject());
    }

    public String getRole(String token) {
        Claims claims = Jwts.parser().verifyWith((SecretKey) signingKey).build().parseSignedClaims(token).getPayload();

        return claims.get("role", String.class);
    }
}