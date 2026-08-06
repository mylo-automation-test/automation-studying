package pass_validator;

public enum ValidationError {

    EMPTY("Password is empty"),
    TOO_SHORT("Password is too short"),
    NO_DIGIT("Password must contain at least one digit"),
    NO_UPPERCASE("Password must contain at least one uppercase character"),
    NO_SPECIAL("Password must contain at least one special character");

    private final String message;

    ValidationError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}