package projectplayground.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // require all requests to be authenticated except for the resources
        http.authorizeRequests().antMatchers("/javax.faces.resources/**")
                .permitAll().anyRequest().authenticated();
        // login
        http.formLogin().loginPage("/login.xhtml").permitAll()
                .failureUrl("/login.xhtml?error=true");
        // logout
        http.logout()
                .clearAuthentication(true)
                .logoutSuccessUrl("/login.xhtml")
                .invalidateHttpSession(true);
        // not needed as JSF 2.2 is implicitly protected against CSRF
        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .inMemoryAuthentication().withUser("marvin")
                .password("{noop}1234").roles("USER").and()
                .withUser("jane.doe").password("{noop}5678").roles("ADMIN");
    }
}