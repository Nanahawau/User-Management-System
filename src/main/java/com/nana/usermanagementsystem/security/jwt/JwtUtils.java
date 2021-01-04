package com.nana.usermanagementsystem.security.jwt;

import com.nana.usermanagementsystem.security.services.UserDetailsImplementation;
import com.nana.usermanagementsystem.security.services.UserDetailsServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import java.io.Serializable;
import java.security.SignatureException;
import java.util.Date;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils implements Serializable {

    private static final long serialVersionUID = 42L;

    @Value("${jwt.secret}")
    private String jwtSecret;

    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

    public String generateJwtToken(Authentication authentication) {
        UserDetailsImplementation userPrincipal = (UserDetailsImplementation) authentication.getPrincipal();

        int jwtExpirationMs = 50 * 60 * 60;
        return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)).signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}
