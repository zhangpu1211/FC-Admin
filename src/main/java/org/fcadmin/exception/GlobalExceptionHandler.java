package org.fcadmin.exception;

import org.fcadmin.utils.RespBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ParamException.class)
    @ResponseBody
    public RespBean paramException(Exception e){
        return RespBean.error("参数异常，操作失败！");
    }


    @ExceptionHandler(TokenException.class)
    @ResponseBody
    public RespBean expiredJwtException(TokenException e){
        return RespBean.jwtError("token错误");
    }
}
