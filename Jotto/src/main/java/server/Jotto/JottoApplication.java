package server.Jotto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@SpringBootApplication
public class JottoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JottoApplication.class, args);
	}

	//Probably not needed
    @Configuration
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(new CorsSupport(), ChannelProcessingFilter.class);
        http
        .authorizeRequests()
        .antMatchers("/","/register","/login")
        .permitAll()
        .and()
.authorizeRequests()
        .anyRequest()
        .authenticated()
        .and().csrf().disable();
    }
		}
    }




