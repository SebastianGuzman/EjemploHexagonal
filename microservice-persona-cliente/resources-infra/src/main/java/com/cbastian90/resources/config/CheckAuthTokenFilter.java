package com.cbastian90.resources.config;

/*
import com.ach.bancoalfa.adapter.out.postgres.repository.AuthTokenReadOnlyRepository;
import com.ach.bancoalfa.adapter.out.postgres.repository.dto.AuthorizationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.security.oauth2.server.resource.web.DefaultBearerTokenResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@Component
public class CheckAuthTokenFilter extends GenericFilterBean {

    private final AuthTokenReadOnlyRepository tokenReadOnlyRepository;

    public CheckAuthTokenFilter(AuthTokenReadOnlyRepository tokenReadOnlyRepository) {
        this.tokenReadOnlyRepository = tokenReadOnlyRepository;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = new DefaultBearerTokenResolver().resolve((HttpServletRequest) servletRequest);
        Optional<AuthorizationToken> authToken = tokenReadOnlyRepository.findByTokenAndTokenType(token, OAuth2AccessToken.TokenType.BEARER.getValue());
        if (!authToken.isPresent()) {
            throw new InvalidBearerTokenException("token not found.");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

}


 */

