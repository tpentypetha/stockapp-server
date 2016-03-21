package gr.mod.mil.stock.web.dto;

public class RegisterDTO {

    private String username;
    private String password;
    private String repeatPassword;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public boolean isValid() {
        return  ! username.isEmpty() &&
                ! password.isEmpty() &&
                ! repeatPassword.isEmpty() &&
                password.equals(repeatPassword);
    }
}
