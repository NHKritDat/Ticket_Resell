package com.nhkritdat.ticket_resell.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import javax.crypto.spec.SecretKeySpec;

@Configuration
public class JwtDecodeConfig implements JwtDecoder {
    @Value("${JWT_SECRET_KEY}")
    private String jwtSecretKey;
    private NimbusJwtDecoder jwtDecoder;

    @Bean
    public JwtDecoder jwtDecoder() {
        jwtDecoder = NimbusJwtDecoder
                .withSecretKey(new SecretKeySpec(jwtSecretKey.getBytes(), "HS256"))
                .macAlgorithm(MacAlgorithm.HS256)
                .build();
        return jwtDecoder;
    }

    @Override
    public Jwt decode(String token) throws JwtException {
        return jwtDecoder.decode(token);
    }
}
