package gr.mod.mil.stock.services;

import gr.mod.mil.stock.dal.model.system.Loginuser;
import gr.mod.mil.stock.dal.model.system.UserType;
import gr.mod.mil.stock.dal.repos.LoginUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class LoginUserService {



    @Autowired
    LoginUserRepository repository;

    @Autowired
    PasswordHasher hasher;

    private final Logger log = LoggerFactory.getLogger(LoginUserService.class);

    public Loginuser createUser(String username, String password) throws UsernameAlreadyExists {

        if (repository.findByUsername(username) != null) {
            throw new UsernameAlreadyExists();
        }

        try {
            Loginuser user = new Loginuser();
            user.setUsername(username);
            PasswordHasher.PasswordHash hash = hasher.createHash(password);
            user.setPassword(hash.getHash());
            user.setSalt(hash.getSalt());
            user.setActive(true);
            user.setType(username.equals("admin") ? UserType.ADMINISTRATOR : UserType.LOGIN);
            return repository.save(user);
        } catch(Exception e) {
            log.error("Failed to hash the user password.");
            return null;
        }
    }

    public class UsernameAlreadyExists extends RuntimeException {
        public UsernameAlreadyExists() {
            super("User name already exists.");
        }
    }

    public UserDetails toUserDetails(Loginuser user) {
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return Arrays.asList(user.getType());
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getUsername();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return user.getActive();
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }

}
