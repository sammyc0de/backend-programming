package syksy26.asset_mgmt;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
	//Needed for enrycpted passwords
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable()) // Disable Cross-Site Request Forgery (CSRF) to allow api requests
			.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/css/**").permitAll() //Allow CSS-files, authentication not needed
				.anyRequest().authenticated() //Require authentication
			).formLogin(formlogin -> formlogin //spring sec based form login
				.defaultSuccessUrl("/", true).permitAll() //Redirect to home page after succesful login
			).httpBasic(Customizer.withDefaults()) //Enable HTTP basic authentication for REST API
			.logout(logout -> logout
				.permitAll() //Allow access to login page
			);
		return http.build();
	}



}
