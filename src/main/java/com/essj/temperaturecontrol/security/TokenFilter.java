package com.essj.temperaturecontrol.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Set;


@Component
public class TokenFilter extends OncePerRequestFilter {

    private static final Set<String> TOKENS_ESP = Set.of("e1ffe7cd-7115-4748-b6c6-372d99f562b8");

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String path = request.getServletPath();

        if ("/medicao/historico".equals(path) || "/medicao/tempatual".equals(path)){
            String token = request.getHeader("Authorization");
            if (token == null || !token.startsWith("Bearer ")) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            String tokenRecebido = token.substring("Bearer ".length());
            if (!TOKENS_ESP.contains(tokenRecebido)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
