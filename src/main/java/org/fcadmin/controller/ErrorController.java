package org.fcadmin.controller;

import org.fcadmin.exception.TokenException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ErrorController {
    @RequestMapping("/error/exthrow")
    public void rethrow(HttpServletRequest request) {
        throw new TokenException("token错误");
    }
}
