package org.fcadmin.config.security;

import org.fcadmin.config.filter.JwtFilter;
import org.fcadmin.config.filter.JwtLoginFilter;
import org.fcadmin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
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
    @Autowired
    MyAuthenticationEntryPoint myAuthenticationEntryPoint;
    @Autowired
    MyLogoutHandler myLogoutHandler;
    @Autowired
    MyUrlAccessDeniedHandler urlAccessDeniedHandler;
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(sysUserService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/login");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.POST, "doLogin").permitAll().anyRequest()
                .authenticated().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                object.setAccessDecisionManager(myAccessDecisionManager);
                object.setSecurityMetadataSource(myFilterInvocationSecurityMetadataSource);
                return object;
            }
        }).and().addFilterBefore(new JwtLoginFilter("/doLogin",authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class).logout().logoutUrl("/logout").logoutSuccessHandler(myLogoutHandler)
        .disable().exceptionHandling().authenticationEntryPoint(myAuthenticationEntryPoint).and()
                .cors()//新加入
                .and()
                .csrf().disable();

    }
    // 登陆验证
//    @Bean
//    MyAuthenticationFilter myAuthenticationFilter() throws Exception {
//        MyAuthenticationFilter filter = new MyAuthenticationFilter();
//        filter.setAuthenticationSuccessHandler(myAuthenctiationSuccessHandler);
//        filter.setAuthenticationFailureHandler(myAuthFailHandler);
//        filter.setAuthenticationManager(authenticationManagerBean());
//        return filter;
//    }

}
