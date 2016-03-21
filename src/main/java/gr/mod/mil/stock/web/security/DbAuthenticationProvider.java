package gr.mod.mil.stock.web.security;


import gr.mod.mil.stock.dal.model.Loginuser;
import gr.mod.mil.stock.dal.repos.LoginUserRepository;
import gr.mod.mil.stock.services.LoginUserService;
import gr.mod.mil.stock.services.PasswordHasher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DbAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private final Logger log = LoggerFactory.getLogger(DbAuthenticationProvider.class);

    @Autowired
    LoginUserRepository repository;

    @Autowired
    PasswordHasher passwords;

    @Autowired
    LoginUserService service;

    @Override
    protected void additionalAuthenticationChecks(UserDetails details, UsernamePasswordAuthenticationToken token) throws AuthenticationException {
        // do nothing in puropose
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken token) throws AuthenticationException {
        Loginuser user = repository.findByUsername(username);
        if (user == null) {
            throw new BadCredentialsException("Λάθος στοιχεία");
        }

        String password = token.getCredentials().toString();
        try {
            if (passwords.matches(password, user.getPassword(), user.getSalt())) {
                return service.toUserDetails(user);
            } else {
                throw new BadCredentialsException("Λάθος στοιχεία");
            }
        } catch(Exception exc) {
            throw new BadCredentialsException("Λάθος στοιχεία");
        }
    }

}
