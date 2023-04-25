

import java.io.IOException;

public class PasswordValidatorTest {
    public static void main(String[] args) throws IOException, WrongLoginException, WrongPasswordException {
        PasswordValidator passwordValidator = new PasswordValidatorImpl();

        passwordValidator.validatePassword("", "", "");                                 // true
        passwordValidator.validatePassword("Vcdm!09_", "Vcdm!09_", "Vcdm!09_");            // true
        passwordValidator.validatePassword("User_admin", "Password_my", "Password_my"); // true



    }
}