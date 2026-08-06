package pass_validator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;

public class PasswordValidatorTest extends TestDataHelper {

    @BeforeMethod
    public void setUp() {
        System.out.println("Test started");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Test finished");
    }

  @Test(groups = "password", dataProvider = "validPassword")
  public void testValidPassowrd(String validPassword){
      PasswordValidator validator = new PasswordValidator(validPassword);
      Assert.assertTrue(validator.isValid(), "Password should be valid: '" + validPassword);
  }

@Test(groups = "password", dataProvider = "invalidPassword")
    public void testInvalidPassword(String invalidPassword){
      PasswordValidator validator = new PasswordValidator(invalidPassword);
      Assert.assertFalse(validator.isValid(), "Password " + invalidPassword + " should be invalid");
}

@Test (groups = "password", dataProvider = "combinedErrors")
    public void testCombinedErrors(String password, List<String> expectedErrors){
      PasswordValidator validator = new PasswordValidator(password);
      List<String> errors = validator.validate();
      Assert.assertTrue(errors.containsAll(expectedErrors), "Missing expected errors for '" + password + " " + errors);
      Assert.assertEquals(errors.size(), expectedErrors.size(), "Unexpected number of errors for '" + password + " " + errors);
}

  @DataProvider(name = "validPassword")

  public Object[][] validPassword() {
      return new Object[][] {
              {VALID_PASSWORD},
              {PASSWORD_WITH_HASH},
              {PASSWORD_WITH_DOLLAR},

            };
        }

    @DataProvider(name = "invalidPassword")

    public Object[][] invalidPassword() {
        return new Object[][] {
                {TOO_SHORT_PASSWORD},
                {WITHOUT_DIGIT_PASSWORD},
                {WITHOUT_UPPERCASE_PASSWORD},
                {WITHOUT_SPECIAL_PASSWORD},
                {EMPTY_PASSWORD},

        };
    }

    @DataProvider(name = "combinedErrors")
    public Object[][] combinedErrors() {
        return new Object[][] {
                { PASSWORD_WITH_TWO_ERRORS, List.of(
                        ValidationError.NO_DIGIT.getMessage(),
                        ValidationError.NO_SPECIAL.getMessage()) },

                { PASSWORD_WITH_ALL_ERRORS, List.of(
                        ValidationError.TOO_SHORT.getMessage(),
                        ValidationError.NO_UPPERCASE.getMessage(),
                        ValidationError.NO_DIGIT.getMessage(),
                        ValidationError.NO_SPECIAL.getMessage()) }
        };
    }

}