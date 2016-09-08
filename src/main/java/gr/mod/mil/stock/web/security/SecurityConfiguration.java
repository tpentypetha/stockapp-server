package gr.mod.mil.stock.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DbAuthenticationProvider provider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/cdBriefReport").permitAll()
                .antMatchers("/briefreport").permitAll()
                .antMatchers("/consumableDepartmentsReport").permitAll()
                .antMatchers("/cdExtendReport").permitAll()
                .antMatchers("/extendreport").permitAll()
                .antMatchers("/cdDepReport").permitAll()
                .antMatchers("/depreport").permitAll()


                .antMatchers("/personel").permitAll()
                .antMatchers("/xreostika").permitAll()
                .antMatchers("/editxreostika").permitAll()
                .antMatchers("/removepcfromuser").permitAll()




                .antMatchers("/api/**").permitAll()
                    .antMatchers("/barcode").permitAll()
                    .antMatchers("/register").permitAll()
                    .antMatchers("/ticketing").permitAll()
                    .antMatchers("/solvedtickets").permitAll()
                .antMatchers("/10solvedtickets").permitAll()

                    .antMatchers("/editticket/{id}/{notes}").permitAll()
                .antMatchers("/get10solved").permitAll()
                .antMatchers("/ticketsreport").permitAll()
                .antMatchers("/addticket").permitAll()
                .antMatchers("/setticketSolved").permitAll()
                .antMatchers("//autofillticket/{phone}").permitAll()


                    .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").permitAll().and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).invalidateHttpSession(true);
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**");
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/fonts/**");
        web.ignoring().antMatchers("/public/images/**");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
    }

}
