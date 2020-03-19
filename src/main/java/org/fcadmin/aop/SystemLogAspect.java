package org.fcadmin.aop;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.fcadmin.mapper.SysLogMapper;
import org.fcadmin.pojo.SysLog;
import org.fcadmin.utils.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Configuration
@Slf4j
public class SystemLogAspect {

    @Autowired
    SysLogMapper sysLogMapper;

    @Pointcut("execution(* org.fcadmin.controller.*.*(..)) && !execution(* org.fcadmin.controller.SysLogController.*(..))")
    public void systemLog() {
    }

    @Around(value = "systemLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();

        // 拿到ip地址、请求路径、token
        String url = request.getRequestURL().toString();
        String ip = IpUtils.getIpAdrress(request);

        // 从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取切入点所在的方法
        Method method = signature.getMethod();
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        String methodName = "";
        if (apiOperation != null) {
            methodName = apiOperation.value();
        }

        // 记录执行时间
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed(joinPoint.getArgs());
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        // 插入系统日志表
        SysLog sysLog = new SysLog();
        sysLog.setMethod(methodName);
        sysLog.setUrl(url);
        sysLog.setIp(ip);
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        sysLog.setUname(name);
        sysLog.setExecuteTime(totalTime + " ms");
        sysLogMapper.insertSelective(sysLog);
        return result;
    }

}

