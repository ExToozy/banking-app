package ru.extoozy.bankingapp.api.security;

import io.github.ilyalisov.jwt.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.GenericFilterBean;
import ru.extoozy.bankingapp.api.security.jwt.TokenType;

import java.io.IOException;


@RequiredArgsConstructor
public class JwtTokenFilter extends GenericFilterBean {

    private final TokenService tokenService;
    private final UserDetailsService userDetailsService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            String token = resolve((HttpServletRequest) request);
            if (isInvalidToken(token)) {
                chain.doFilter(request, response);
                return;
            }
            Authentication auth = getAuthentication(token);
            if (auth == null) {
                chain.doFilter(request, response);
                return;
            }
            SecurityContextHolder.getContext().setAuthentication(auth);
        } catch (Exception ignored) {
        }
        chain.doFilter(request, response);
    }

    private String resolve(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return "";
    }

    private boolean isInvalidToken(String token) {
        if (token.isEmpty()) {
            return true;
        }
        if (!tokenService.getType(token).equals(TokenType.ACCESS.name())) {
            return true;
        }
        if (tokenService.isExpired(token)) {
            return true;
        }
        return false;
    }

    private Authentication getAuthentication(String token) {
        String subject = tokenService.getSubject(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(subject);
        if (userDetails != null) {
            return new UsernamePasswordAuthenticationToken(
                    userDetails,
                    "",
                    userDetails.getAuthorities()
            );
        }
        return null;
    }
}
