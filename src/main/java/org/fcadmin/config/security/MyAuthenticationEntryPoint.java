package org.fcadmin.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fcadmin.utils.RespBean;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
        resp.setContentType("application/json;charset=utf-8");
        resp.setStatus(401);
        PrintWriter out = resp.getWriter();
        RespBean respBean = RespBean.error("访问失败!");
        if (e instanceof InsufficientAuthenticationException) {
            respBean.setMsg("请求失败，请联系管理员!");
        }
        out.write(new ObjectMapper().writeValueAsString(respBean));
        out.flush();
        out.close();
    }
}
