package org.fcadmin.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fcadmin.utils.RespBean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class MyUrlAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse resp, AccessDeniedException e) throws IOException, ServletException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        RespBean error = RespBean.urlDeniedError(e.getMessage(), null);
        String s = new ObjectMapper().writeValueAsString(error);
        out.write(s);
        out.flush();
        out.close();
    }
}
