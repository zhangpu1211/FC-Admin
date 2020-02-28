package org.fcadmin.exception;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.fcadmin.utils.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

public class GlobalExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e){
        if(e instanceof MySQLIntegrityConstraintViolationException){
            return RespBean.error("该数据有关联数据，操作失败！");
        }
        return RespBean.error("数据库异常，操作失败！");
    }
    @ExceptionHandler(ParamException.class)
    public RespBean paramException(SQLException e){
        return RespBean.error("参数异常，操作失败！");
    }
}
