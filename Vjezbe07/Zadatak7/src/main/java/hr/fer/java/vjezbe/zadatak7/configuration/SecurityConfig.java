package hr.fer.java.vjezbe.zadatak7.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@EnableGlobalMethodSecurity(securedEnabled = true) @EnableWebSecurity public class SecurityConfig
        extends WebSecurityConfigurerAdapter {

    @Qualifier("dataSource") @Autowired private DataSource dataSource;

    @Override protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() //
                .antMatchers("/css/**", "/index").permitAll()//
                .antMatchers("/library/**").hasAnyRole("LIBRARIAN", "ADMIN")//
                .and().formLogin().loginPage("/login")//
                .failureUrl("/login-error");//
    }

    @Autowired public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder());
    }
}
