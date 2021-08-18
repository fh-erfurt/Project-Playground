package projectplayground.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.header.writers.DelegatingRequestMatcherHeaderWriter;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // not needed as JSF 2.2 is implicitly protected against CSRF
        http.csrf().disable();

        // require all requests to be authenticated except for the resource
        http
                .authorizeRequests()
                .antMatchers("/javax.faces.resource/**").permitAll()
                .antMatchers("/**").authenticated();

        // login
        http.formLogin().loginPage("/login.xhtml").permitAll()
                .failureUrl("/login.xhtml?error=true");
        // logout
        http.logout()
                .clearAuthentication(true)
                .logoutSuccessUrl("/login.xhtml")
                .invalidateHttpSession(true);

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
//                .jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder()).dataSource(dataSource)
//                .usersByUsernameQuery("select username,password from user where username=?")
//                .authoritiesByUsernameQuery("select username, 'ROLE_USER' from user where login=?");
                .inMemoryAuthentication()
                .withUser("marvin")
                .password("{noop}12345").roles("ADMIN")
                .and()
                .withUser("mark").password("{noop}12345").roles("ADMIN")
                .and()
                .withUser("katja").password("{noop}12345").roles("ADMIN")
                .and()
                .withUser("fabian").password("{noop}12345").roles("ADMIN");

        //jdbc auth didnt work, thatswhy we're using hardcoded logins...
    }
}