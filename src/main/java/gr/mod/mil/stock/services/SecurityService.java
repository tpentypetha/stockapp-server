package gr.mod.mil.stock.services;

import gr.mod.mil.stock.dal.model.UserType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    public boolean isAuthorizedAsAdmin(UserDetails userDetails){
        return userDetails.getAuthorities().contains(UserType.ADMINISTRATOR);
    }

}
