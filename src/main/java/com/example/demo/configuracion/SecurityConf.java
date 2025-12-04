package com.example.demo.configuracion;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConf {
   
    @Autowired 
      DataSource dataSource;
      
      @Autowired
      public void configure(AuthenticationManagerBuilder amb) throws Exception {
        amb.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, enabled "+
                "from usuario where username = ?")
            .authoritiesByUsernameQuery("select u.username, r.rol as 'authority' "+
                "from usuario u, rol_usuario r " +
                "where u.id=r.usuario_id and username = ?");
      }

      @Bean
        public SecurityFilterChain filter(HttpSecurity http) throws Exception {
                return http
                        .authorizeHttpRequests((requests) -> requests
                                .requestMatchers("/webjars/**", "/img/**", "/js/**","/register/**", "/ayuda/**", "/login", "/codpos/**","/denegado", "/error", "/acerca")
                                .permitAll()
                                .requestMatchers("/pedidos/**", "/pedidos/*/**", "/pedidos/*/*/**", "/pedidos/*/*/*/**", "/pedidos/*/*/*/*/**"))

                                .formLogin((formLogin) -> formLogin
                                .loginPage("/login")
                                .permitAll()).build();
                                

        }

}



