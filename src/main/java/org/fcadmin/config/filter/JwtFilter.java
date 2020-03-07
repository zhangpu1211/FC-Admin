package org.fcadmin.config.filter;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

            HttpServletRequest req = (HttpServletRequest) servletRequest;
            String jwtToken = req.getHeader("Authorization");
        try {
            Jws<Claims> jws = Jwts.parser().setSigningKey("fcadmin").parseClaimsJws(jwtToken.replace("Bearer", ""));
            Claims claims = jws.getBody();
            String username = claims.getSubject();
            List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(token);
            filterChain.doFilter(req, servletResponse);
        }catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | IllegalArgumentException e) {
            servletRequest.getRequestDispatcher("/error/exthrow").forward(servletRequest, servletResponse);
        }
    }
}
