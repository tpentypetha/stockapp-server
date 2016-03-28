package gr.mod.mil.stock.dal.model.system;

import org.springframework.security.core.GrantedAuthority;

public enum UserType implements GrantedAuthority {

    ADMINISTRATOR {
        @Override
        public String getAuthority() {
            return "ADMIN";
        }
    }, LOGIN {
        @Override
        public String getAuthority() {
            return "LOGIN";
        }
    };

}
