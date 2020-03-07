package org.fcadmin.config.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.fcadmin.dto.output.SysUserVO;
import org.fcadmin.pojo.SysUser;
import org.fcadmin.utils.RespBean;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    public JwtLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse rep) throws AuthenticationException, IOException, ServletException {
        SysUserVO sysUserVO = new ObjectMapper().readValue(req.getInputStream(), SysUserVO.class);
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(sysUserVO.getUsername(),sysUserVO.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse resp, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
        StringBuffer sb = new StringBuffer();
        for(GrantedAuthority authority : authorities){
            sb.append(authority.getAuthority()).append(",");
        }
        String jwt = Jwts.builder().claim("authorities", sb).setSubject(authResult.getName()).setExpiration(new Date(System.currentTimeMillis()+60*60*1000))
                .signWith(SignatureAlgorithm.HS512, "fcadmin").compact();
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
//        返回对象
        Map<String,Object> map = new HashMap<>();
        map.put("token",jwt);
        SysUserVO sysUserVO = (SysUserVO) authResult.getPrincipal();
        sysUserVO.setPassword(null);
        map.put("userInfo", sysUserVO);
        RespBean ok = RespBean.ok("登录成功!",map);
        String s = new ObjectMapper().writeValueAsString(ok);
        out.write(s);
        out.flush();
        out.close();
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest req, HttpServletResponse resp, AuthenticationException exception) throws IOException, ServletException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        RespBean respBean = RespBean.error("登录失败!");
        if (exception instanceof LockedException) {
            respBean.setMsg("账户被锁定，请联系管理员!");
        } else if (exception instanceof CredentialsExpiredException) {
            respBean.setMsg("密码过期，请联系管理员!");
        } else if (exception instanceof AccountExpiredException) {
            respBean.setMsg("账户过期，请联系管理员!");
        } else if (exception instanceof DisabledException) {
            respBean.setMsg("账户被禁用，请联系管理员!");
        } else if (exception instanceof BadCredentialsException) {
            respBean.setMsg("用户名或者密码输入错误，请重新输入!");
        }
        out.write(new ObjectMapper().writeValueAsString(respBean));
        out.flush();
        out.close();
    }
}
