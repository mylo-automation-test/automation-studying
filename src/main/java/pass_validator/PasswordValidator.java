package pass_validator;
import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

    private String password;
    private int minLenght = 8;


    public PasswordValidator(String password) {
        this.password = password;
    }

    private boolean hasDigit(){
        for (char symbol : password.toCharArray()){
            if (Character.isDigit(symbol))
            return true;
        }
        return false;
    }

    private boolean hasUpperCase(){
        for (char symbol : password.toCharArray()){
            if (Character.isUpperCase(symbol))
            return true;
        }
        return false;
    }

    private boolean hasSpecialCharacter(){
        for (char symbol : password.toCharArray()){
            if (!Character.isLetterOrDigit(symbol))
            return true;
        }
        return false;
    }

    public List<String> validate (){
        List<String> errors = new ArrayList<>();
        if (password.isEmpty()) {
            errors.add("Password is empty");
            return errors;
        }
        if (password.length() < minLenght) {
            errors.add("Password is too short");
        }
        if (!hasDigit()){
            errors.add("Password must contain at least one digit");
        }
        if (!hasUpperCase()){
            errors.add("Password must contain at least one uppercase character");
        }
        if (!hasSpecialCharacter()){
            errors.add("Password must contain at least one special character");
        }

        return errors;
    }


}
