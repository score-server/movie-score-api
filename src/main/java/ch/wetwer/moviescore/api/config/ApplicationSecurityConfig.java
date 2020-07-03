package ch.wetwer.moviescore.api.config;

import ch.wetwer.moviescore.api.data.access.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Collection;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDao userDao;

    @Autowired
    public ApplicationSecurityConfig(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/")
                .and()
                .rememberMe();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        Collection<UserDetails> userDetails = new ArrayList<>();

        for (ch.wetwer.moviescore.api.data.entity.User user :
                userDao.getAll()) {
            userDetails.add(
                    User.builder()
                            .username(user.getName())
                            .password(user.getPasswordSha())
                            .roles(user.getRole().name())
                            .build()
            );


        }

        return new InMemoryUserDetailsManager(userDetails);

    }
}
