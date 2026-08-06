package pass_validator;

public class TestDataHelper {

    public static String VALID_PASSWORD = "Abcdefg1!";
    public static String PASSWORD_WITH_HASH = "Qwerty12#";
    public static String PASSWORD_WITH_DOLLAR = "MyPass99$";
    public static String TOO_SHORT_PASSWORD = "Abc1!";
    public static String WITHOUT_DIGIT_PASSWORD = "Abcdefgh!";
    public static String WITHOUT_UPPERCASE_PASSWORD = "abcdefg1!";
    public static String WITHOUT_SPECIAL_PASSWORD = "Abcdefg12";
    public static String EMPTY_PASSWORD = "";
    public static String PASSWORD_WITH_TWO_ERRORS = "Abcdefgh";
    public static String PASSWORD_WITH_ALL_ERRORS = "abcdefg";
}