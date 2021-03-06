package hr.fer.java.vjezbe.zadatak7.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@EnableGlobalMethodSecurity(securedEnabled = true) @EnableWebSecurity public class SecurityConfig
        extends WebSecurityConfigurerAdapter {

    @Qualifier("dataSource") @Autowired private DataSource dataSource;

    @Autowired private CustomAuthenticationProvider authenticationProvider;

    @Override protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and().
                authorizeRequests().
                antMatchers(HttpMethod.GET, "/api/**").permitAll().
                antMatchers(HttpMethod.POST, "/api/**").permitAll().
                anyRequest().permitAll();
        //        http.authorizeRequests() //
        //                .antMatchers("/css/**", "/index", "/api/**").permitAll()//
        //                .antMatchers("/library/**").hasAnyRole("LIBRARIAN", "ADMIN")//
        //.and().formLogin().loginPage("/login")//
        //.failureUrl("/login-error")
        ;//
    }

    @Autowired public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder());
        auth.authenticationProvider(authenticationProvider);
    }
}
