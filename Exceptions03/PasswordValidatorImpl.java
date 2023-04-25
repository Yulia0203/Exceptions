public class PasswordValidatorImpl implements PasswordValidator {
    String regex = "[V-cd-m!0-9_]*"; 
    int lengthMax = 19;
    @Override
    public boolean validatePassword(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        boolean result = false;
        try {
            if (!login.matches(regex)) {
                throw new WrongLoginException("Логин содержит недопустимые символы");
            } else if (login.length() >= lengthMax) {
                throw new WrongLoginException("Логин слишком длинный");

            } else if (!password.matches(regex) || !confirmPassword.matches(regex)) {
                throw new WrongPasswordException("Пароль содержит недопустимые символы");
            } else if (password.length() >= lengthMax || confirmPassword.length() >= lengthMax) {
                throw new WrongPasswordException("Пароль слишком длинный");

            } else if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароль и подтверждение не совпадают");

            } else {
                result = true;
                printResult(login, password, confirmPassword, result);
            }
        } catch (WrongLoginException wle) {
            System.out.println(wle.getMessage());

        }

        return result;
    }

    private void printResult(String login, String password, String confirmPassword, boolean result) {
        System.out.println("This set: ");
        System.out.println(
                login + " -> login ok\n"
                + password + " -> password ok\n"
                + confirmPassword + " -> confirmPassword ok"
        );

        if (result) {
            System.out.println(result + " -> passwords are equal\n");
        } else {
            System.out.println(result + " -> passwords are not equal\n");
        }
    }
}