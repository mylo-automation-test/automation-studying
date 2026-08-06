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
            if (Character.isDigit(symbol)){
                return true;
            }
        }
        return false;
    }

    private boolean hasUpperCase(){
        for (char symbol : password.toCharArray()){
            if (Character.isUpperCase(symbol)){
                return true;
            }
        }
        return false;
    }

    private boolean hasSpecialCharacter(){
        for (char symbol : password.toCharArray()){
            if (!Character.isLetterOrDigit(symbol)) {
                return true;
            }
        }
        return false;
    }

    public List<String> validate (){
        List<String> errors = new ArrayList<>();
        if (password.isEmpty()) {
            errors.add(ValidationError.EMPTY.getMessage());
            return errors;
        }
        if (password.length() < minLenght) {
            errors.add(ValidationError.TOO_SHORT.getMessage());
        }
        if (!hasDigit()){
            errors.add(ValidationError.NO_DIGIT.getMessage());
        }
        if (!hasUpperCase()){
            errors.add(ValidationError.NO_UPPERCASE.getMessage());
        }
        if (!hasSpecialCharacter()){
            errors.add(ValidationError.NO_SPECIAL.getMessage());
        }

        return errors;
    }

    public boolean isValid() {
        List<String> errors = validate();
        return errors.isEmpty();
    }


}
