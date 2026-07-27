package pass_validator;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Check your password strength ");
        String userPassword = scanner.nextLine();
        PasswordValidator validator = new PasswordValidator(userPassword);
        List<String> errors = validator.validate();


        System.out.println("Validation Result");
        if (errors.isEmpty()){
            System.out.println("Password is valid");
        } else {
            for (String error : errors){
                System.out.println(error);
            }
        }
    scanner.close();
    }
}
