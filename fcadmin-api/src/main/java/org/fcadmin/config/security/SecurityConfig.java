package org.fcadmin.config.security;

import org.fcadmin.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyAuthenctiationSuccessHandler myAuthenctiationSuccessHandler;
    @Autowired
    MyAuthFailHandler myAuthFailHandler;
    @Autowired
    SysUserService sysUserService;
    @Autowired
    MyFilterInvocationSecurityMetadataSource myFilterInvocationSecurityMetadataSource;
    @Autowired
    MyAccessDecisionManager myAccessDecisionManager;
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(sysUserService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests().anyRequest().authenticated()
                .and().formLogin()
                .loginProcessingUrl("/doLogin")  //处理登录请求的地址
                .successHandler(myAuthenctiationSuccessHandler)
                .failureHandler(myAuthFailHandler)
                .and()
                .csrf().disable();
    }
}
