package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

import static com.example.demo.common.WebConst.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * 静的ファイルには認証をかけない
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/favicon.ico", "/css/**", "/js/**", "/images/**", "/fonts/**", "/shutdown" /* for Demo */);
    }

    /**
     * UserDetailsServiceインターフェースを実装した独自の認証レルムを使用する設定
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/loginFrom").permitAll()//ログインフォーム
                .antMatchers("/user/**").permitAll()
                .antMatchers("/new").permitAll()//test用(ユーザ登録)
                .antMatchers("/index").permitAll()//test用(ユーザ登録後の遷移画面）
                .antMatchers("/user/create").permitAll()//test用機能
                .anyRequest().authenticated();
        http.formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/loginFrom")
                .failureUrl("/login?error")
                .successForwardUrl("/success")
                .usernameParameter("email")
                .passwordParameter("password");
        http.logout()
                .logoutUrl("/logout**")
                .logoutSuccessUrl("/login");
    }





}
